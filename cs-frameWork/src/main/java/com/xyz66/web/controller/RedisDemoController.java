
package com.xyz66.web.controller;

import com.xyz66.enums.AppHttpCodeEnum;
import com.xyz66.web.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RequestMapping("redis/demo")
@RestController
public class RedisDemoController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 数据还原
     *
     * @return
     */
    @GetMapping("/reset")
    public void reset() {
        // 删除数据,设置数据，设置过期时间
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        redisTemplate.delete("用户:1001");// 这里1001只是模拟用户id
        ops.set("货物:1001", 10);
    }

    /**
     * 秒杀场景模拟一，使用redis原生命令，不使用spring-data-redis，使用redisTemplate
     * 模拟秒杀场景，用户购买商品，库存减少，用户id放入购物车
     *
     * @return
     */
    @GetMapping("/seckill")
    public ResponseResult seckill() {
        // 1000个用户
        int userId = new Random().nextInt(1000);
        // 获取商品数量
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        // 获取用户购物车
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        // 库存大于0
        if (Integer.parseInt(Objects.requireNonNull(ops.get("货物:1001")).toString()) > 0) {
            // 减库存，并将用户id放入购物车，返回成功，否则返回失败
            ops.decrement("货物:1001");
            listOperations.leftPush("用户:1001", String.valueOf(userId));
            System.out.println(listOperations.range("用户:1001", 0, -1));
            return ResponseResult.okResult();
        } else {
            // 在后端直接返回错误，Response code:500,便于在JMeter中查看错误,不用在前端处理
            throw new RuntimeException("库存不足");
//            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR, "库存不足");
        }
    }

    /**
     * 秒杀场景模拟二
     * 相比于上面的秒杀场景，使用spring-data-redis，使用redisTemplate，使用lua脚本
     * 
     * @return
     */
    @GetMapping("/seckill/lua")
    public ResponseResult seckillWithLua() {
        // 1000个用户
        int userId = new Random().nextInt(1000);
        // 获取商品数量
        String script = "if tonumber(redis.call('get', KEYS[1]))>0 then redis.call('decr',KEYS[1]) redis.call('lpush', KEYS[2], ARGV[1]) return 1 else return 0 end";
        // 设置脚本
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        // 在脚本中使用KEYS[1]，KEYS[2]，ARGV[1]，ARGV[2]
        redisScript.setScriptText(script);
        // 设置返回类型
        redisScript.setResultType(Long.class);
        
        // 这里KEYS[1]是商品库存，KEYS[2]是用户购物车
        List<String> keysList = new ArrayList<>();
        keysList.add("货物:1001");
        keysList.add("用户:1001");

        // 执行脚本
        Long result = (Long) redisTemplate.execute(redisScript, keysList, String.valueOf(userId));

        // 获取库存和购物车
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();

        // 库存大于0
        if (result == 1) {
            System.out.println(ops.get("货物:1001"));
            System.out.println(listOperations.range("用户:1001", 0, -1));
            return ResponseResult.okResult();
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR, "库存不足");
        }
    }
}

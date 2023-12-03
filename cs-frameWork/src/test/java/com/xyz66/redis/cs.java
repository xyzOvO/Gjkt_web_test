package com.xyz66.redis;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz66.redis.pojo.User;
import com.xyz66.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/3 11:32
 */
@SpringBootTest
public class cs {
    
    @Autowired
    @Qualifier("redisTemplate")// 指定特定的依赖对象
    private RedisTemplate redisTemplate;
    
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void cs1(){
        // RedisTemplate
        redisTemplate.opsForValue().set("key", "HelloWorld!");// set
        System.out.println(redisTemplate.opsForValue().get("key"));
    }
    @Test
    public void cs2() throws JsonProcessingException {
        // 真实开发使用JSON来传递对象
        User user = new User("测试", 22);
        String s = new ObjectMapper().writeValueAsString(user);
        redisUtil.set("user", s);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}

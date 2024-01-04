package com.xyz66.web.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/4 9:35
 */
@Component
@SpringBootTest
public class RedisCache {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        // 测试RedisTemplate
        if (!redisTemplate.hasKey("key")) {
            redisTemplate.opsForValue().set("key", "value");
            System.out.println(redisTemplate.opsForValue().get("key"));
        }else {
            System.out.println("已有该缓存");
        }
    }
}

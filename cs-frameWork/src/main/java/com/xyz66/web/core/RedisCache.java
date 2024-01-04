package com.xyz66.web.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/4 9:35
 */
@Component
@SpringBootTest
public class RedisCache {
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void test() {
        // 测试RedisTemplate
        redisTemplate.opsForValue().set("key", "value");
        System.out.println(redisTemplate.opsForValue().get("key"));
    }
}

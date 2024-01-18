package com.xyz66;

import com.xyz66.web.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/18 18:30
 */
@SpringBootTest
public class Action {
    @Resource
    private TestService testService;
    @Test
    public void main() {
        // 测试注入
        System.out.println(testService.test());
    }
}

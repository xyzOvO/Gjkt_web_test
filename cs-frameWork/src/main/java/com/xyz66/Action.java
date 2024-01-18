package com.xyz66;

import com.xyz66.web.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/18 18:30
 */
@SpringBootApplication
public class Action {
    @Resource
//    @Autowired
    private TestService testService;// 手动装配要去扫描
    @Test
    public void main() {
        // 测试注入->去12/18-Cs.java
        SpringApplication.run(Action.class);
    }
}

package com.xyz66;

import com.xyz66.config.AppConfig;
import com.xyz66.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/18 18:30
 */
@SpringBootApplication
public class Action {
    @Autowired
    private TestService testService;
    public static void main(String[] args) {
//        SpringApplication.run(Action.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // 假设你有一个配置类AppConfig，其中定义了UserServiceImpl的Bean。  
        TestService bean = context.getBean(TestService.class);// 从ApplicationContext中获取Action Bean。  
        System.out.println(bean.test());
    }
}

package com.xyz66;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/16 10:52
 */

@MapperScan("com.xyz66.web.mapper")// 扫描mapper，创包了记得改
@SpringBootApplication// 核心注解,组合了@SpringBootConfiguration:配置文件，@EnableAutoConfiguration:打开自动配置，@ComponentScan:Spring组件扫描
@EnableTransactionManagement
public class CsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsApplication.class,args);
    }
}

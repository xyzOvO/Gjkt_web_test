package com.xyz66;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/16 10:52
 */



@MapperScan("com.xyz66.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class CsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsApplication.class,args);
    }
}

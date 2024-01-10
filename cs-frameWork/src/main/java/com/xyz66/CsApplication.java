package com.xyz66;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/16 10:52
 */

@EnableCaching// 开启缓存注解功能
@EnableSwagger2// 启动接口文档
@MapperScan("com.xyz66.web.mapper")// 扫描mapper，创包了记得改
@SpringBootApplication// 核心注解,组合了@SpringBootConfiguration:配置文件，@EnableAutoConfiguration:打开自动配置，@ComponentScan:Spring组件扫描
@EnableTransactionManagement
@Transactional(rollbackFor = Exception.class)// 开启事务
public class CsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsApplication.class,args);
    }
}

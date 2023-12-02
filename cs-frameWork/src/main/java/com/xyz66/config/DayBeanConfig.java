package com.xyz66.config;

import com.xyz66.prop.DayBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/2 15:34
 */
@Configuration
@EnableAutoConfiguration
public class DayBeanConfig {
    // 读取配置信息
    @Bean
    @ConfigurationProperties("cs")// 读取配置，获得实例化对象
    public DayBean getDayBean(){
        return new DayBean();
    }
    
}

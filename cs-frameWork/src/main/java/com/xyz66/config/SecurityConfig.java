package com.xyz66.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)// 启用全局方法级别的安全控制
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 配置Security的过滤器链
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // CSRF禁用,不使用session,POST请求403错误
                .csrf().disable()
                // 禁用HTTP响应标头
                .headers().cacheControl().disable().and()
                // 认证配置
                .authorizeRequests()
                // 任何请求，访问的用户都需要经过认证
//                .anyRequest().authenticated();
                // 全部通过
                .anyRequest().permitAll();
    }
}
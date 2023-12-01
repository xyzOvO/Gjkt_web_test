package com.xyz66.AOP.annotation;

import java.lang.annotation.*;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/11/30 16:15
 */
/**
 * 自定义注解
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })// 注解应用类型，参数，方法
@Retention(RetentionPolicy.RUNTIME)// 元注解
@Documented // 是注解
public @interface cs {
    String value() default "";
}

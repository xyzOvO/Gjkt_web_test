package com.xyz66.AOP.aspect;

import com.alibaba.fastjson.JSON;
import com.xyz66.AOP.annotation.cs;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/1 13:41
 */
/**
 * 切面类
 */
@Component
@Aspect
public class csAspct {
    @Pointcut("@annotation(com.xyz66.AOP.annotation.cs)")
    public void pointcut() {
    }
    
    @Around("pointcut()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("------Around环绕前--------");
        Signature signature = joinPoint.getSignature();// 得到签名
        MethodSignature methodSignature = (MethodSignature) signature;// 强转为方法签名
        Method method = methodSignature.getMethod();// 得到方法
        cs annotation = method.getAnnotation(cs.class);// 得到注解
        System.out.println("注解的value为:"+annotation.value());// 输出注解的值
        Object proceed = joinPoint.proceed();
        System.out.println(JSON.toJSONString(proceed));
        System.out.println("------Around环绕后--------");
        return proceed;
    }
}

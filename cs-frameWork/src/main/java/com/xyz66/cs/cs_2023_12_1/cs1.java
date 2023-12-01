package com.xyz66.cs.cs_2023_12_1;

import com.xyz66.AOP.annotation.cs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/1 13:46
 */
@SpringBootTest// AOP是spring的特性，需要在测试类上加上@SpringBootTest
public class cs1 {
    @Test
    @cs(value = "123")
    public void test() {
        System.out.println("AOP加强的方法。");
    }
}

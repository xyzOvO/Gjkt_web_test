package com.xyz66.cs.cs_2024_1_4;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/4 9:30
 */
//@SpringBootTest
public class MyTest {
    @Resource
    private Fun fun;

    @Test
    public void test() {
        fun.test();
    }

    @Test
    public void test1() {
        System.out.println(SeasonEnum.AUTUMN.getValue());
    }

    @Test
    public void test2() {
        StaticTest staticTest = new StaticTest();
        staticTest.test();// 增加编译器解析成本
        // 正确
        StaticTest.test();
    }

    @Test
    public void test3() {
        float f1 = 2.0F - 1.9F;
        float f2 = 3.0F - 2.9F;
        if (f1 == f2) {
            System.out.println("执行");
        }
    }

    @Test
    public void test4() {
        float f1 = 2.0F - 1.9F;
        float f2 = 3.0F - 2.9F;
        float diff = 1e-6F;
        if (Math.abs(f1 - f2) < diff) {
            System.out.println("执行");
        }
    }

    @Test
    public void test5() {
        BigDecimal bigDecimal1 = new BigDecimal("2.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.9");
        System.out.println(bigDecimal1.subtract(bigDecimal2));// 减去
        System.out.println(bigDecimal1.compareTo(new BigDecimal("2.0000")));// 比较，忽略精度，相等返0，不等反-1

    }

    @Test
    public void test6() {
        EntityTest entityTest = new EntityTest();
        System.out.println(entityTest);
    }

    @Test
    public void test7() {
        String s = "a,b,c,,";
        int len = s.length();
        String[] split = s.split(",");
        if (s.charAt(len - 1) == ',') {
            // 原数组添加
            split = Arrays.copyOf(split, split.length + 1);
            split[split.length - 1] = ",";
        }
        System.out.println(split.length);
        System.out.println(Arrays.toString(split));
    }
}

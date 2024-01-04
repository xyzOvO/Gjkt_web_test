package com.xyz66.cs.cs_2024_1_4;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

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
    public void test(){
        fun.test();
    }
    @Test
    public void test1(){
        System.out.println(SeasonEnum.AUTUMN.getValue());
    }
}

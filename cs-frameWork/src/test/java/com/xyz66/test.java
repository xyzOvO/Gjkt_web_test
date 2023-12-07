package com.xyz66;

import org.junit.jupiter.api.Test;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/5 13:14
 */
public class test {
    @Test
    public void cs() {
        // 测试反转
        String s = "123456789";
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        System.out.println(s1);
    }

    @Test
    public void cs1() {
        String s1 = "";
        String s2 = "你好";
        String[] split = (s1+"-"+s2).split("-");
        System.out.println(split[0]+"|-|"+split[1]);
    } 
    @Test
    public void cs2() {
        // 不知道切谁
        String[] split = "猫三棂-你好".split("-");
        String cs = split.length>1?split[1]+split[0]:split[0];
        System.out.println(cs);
    }
}

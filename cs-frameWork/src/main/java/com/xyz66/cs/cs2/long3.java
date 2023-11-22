package com.xyz66.cs.cs2;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/22 12:26
 */
public class long3 {
    // apache.commons.lang3常用工具类

    @Test
    public void cs1() {
        System.out.println("yy".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(" ".isEmpty());
        System.out.println("------------------");
        System.out.println(StringUtils.isEmpty("yy"));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
    }

    @Test
    public void cs2() {
        // 清除空白字符
        System.out.println(" C S ".replace(" ", ""));
        System.out.println(" C S ".trim());//去掉首尾空格
    }

    @Test
    public void cs3() {
        // 颠倒字符串
        System.out.println(StringUtils.reverse("cs"));
    }

    @Test
    public void cs4() {
        // 重复字符串
        System.out.println(StringUtils.repeat("cs", 10));
        // 字符串插入重复*中间
        System.out.println(StringUtils.center("China", 111, "*"));
    }

    @Test
    public void cs5() {
        String str = "  ";
        StringUtils.isNumeric(str);
        //如果str全由数字组成返回True.

        StringUtils.isAlpha(str);
        //如果str全由字母组成返回True.

        StringUtils.isAlphanumeric(str);
        //如果str全由数字或数字组成返回True.

        StringUtils.isAlphaSpace(str);
        //如果str全由字母或空格组成返回True.

        StringUtils.isAlphanumericSpace(str);
        //只由字母数字和空格组成

        StringUtils.isNumericSpace(str);
        //只由数字和空格组成
    }
    @Test
    public void cs6(){
        StringUtils.countMatches("cs2333","3");
        String string = null;
        int c = 1;
        System.out.println(ObjectUtils.isEmpty(c));
    }
}

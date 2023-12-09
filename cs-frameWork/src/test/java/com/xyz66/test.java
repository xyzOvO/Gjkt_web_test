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
        String operate = "完成了";
        String[] strings = "猫三棂-第三轮".split("-");
        operate = strings.length > 1 ? operate + strings[1] : operate;// 判断-轮次加类型后
        System.out.println(operate);
    }
}

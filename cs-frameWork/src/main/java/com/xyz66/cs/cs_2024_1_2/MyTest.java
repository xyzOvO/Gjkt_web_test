package com.xyz66.cs.cs_2024_1_2;

import org.junit.jupiter.api.Test;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/2 14:13
 */
public class MyTest {
    public String ResPhone(String phone) {
        if (!phone.isEmpty()) {
//            return phone.substring(0, 3) + "****" + phone.substring(7);
            return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        } else {
            return phone;
        }
    }
    @Test
    public void test() {
        // 电话号码脱敏
        String s = ResPhone("18164106994");
        System.out.println(s);
    }
}

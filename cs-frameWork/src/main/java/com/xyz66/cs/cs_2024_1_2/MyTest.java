package com.xyz66.cs.cs_2024_1_2;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    public static Long[] convertToLongArray(String[] stringArr) {
        if (ArrayUtils.isEmpty(stringArr)) {
            return new Long[]{}; // 返回空长度的Long数组
        } else {
            Long[] longArr = new Long[stringArr.length];
            for (int i = 0; i < stringArr.length; i++) {
                try {
                    longArr[i] = Long.parseLong(stringArr[i]);
                } catch (NumberFormatException e) {
                    System.out.println("无法将字符串 " + stringArr[i] + " 转换为Long类型");
                }
            }
            return longArr;
        }
    }
    @Test
    public void test2(){
        // id长度精度失精
        String[] strings = new String[]{"1740181568661622784"};
        for (String string : strings) {
            System.out.println(string);
        }
//        int[] ints = {1,2,3};
        Long[] longs = convertToLongArray(strings);
        for (Long aLong : longs) {
            System.out.println(aLong);
        }
    }

    public static byte[] randomUUID() {
        byte[] randomBytes = {0,1};
//        randomBytes[6] &= 0x0f; /* clear version */
//        randomBytes[6] |= 0x40; /* set to version 4 */
//        randomBytes[8] &= 0x3f; /* clear variant */
//        randomBytes[8] |= 0x80; /* set to IETF variant */
        System.out.println(Arrays.toString(randomBytes));
        return randomBytes;
    }
    @Test
    public void test3(){
        // 随机生成uuid
        byte[] bytes = randomUUID();
    }
}

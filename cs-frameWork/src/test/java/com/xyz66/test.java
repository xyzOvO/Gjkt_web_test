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

    @Test
    public void cs2() {
        try {
            // 二分测试,log测试
//        int[] arr = new int[]{1, 4, 1, 3, 5, 2, 4, 4, 7};
            // 有序的数组
            int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            int l = -1;
            int r = arr.length;
            int find = 6;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (mid < find) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            System.out.println(l);
        } catch (Exception e) {
            e.printStackTrace();
            /**
             * catch 时请分清稳定代码和非稳定代码，
             * 稳定代码指的是无论如何不会出错的代码。对于非稳定 代码的 catch 尽可能进行区分异常类型，
             * 再做对应的异常处理。
             *
             * 生产环境禁止使用 System.out 或 System.err 输出或使用 e.printStackTrace() 打印异常堆栈。
             * printStackTrace()默认使用了System.err输出流进行输出，与System.out是两个不同的输出流，
             * 那么在打印时自然就形成了交叉。再就是输出流是有缓冲区的，所以对于什么时候具体输出也形成了随机。
             * 一般打印错误日志的时候我们都是用日志框架的log.error("",e)，基本够用了。
             */
        }
    }

    @Test
    public void cs3() {
        // 字符串截取
        String s = "123@qq";
        String substring = s.substring(s.indexOf("@") + 1);
        System.out.println(substring);
    }

    @Test
    public void cs4() {
        // 字符串split
        String s = "admin,common";
        String[] split = s.split(",");
        for (String string : split) {
            System.out.println(string);
        }
    }

}

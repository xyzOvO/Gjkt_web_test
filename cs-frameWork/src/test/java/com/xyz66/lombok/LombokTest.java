package com.xyz66.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LombokTest {
    @Test
    public void cs1() {
        // Lombok的val使用
        val cs = new ArrayList<String>();
        cs.add("1");
        System.out.println(cs);
        val cs1 = new HashMap<String, String>();
        cs1.put("1", "1");
        System.out.println(cs1);
    }

    @Test
    public void cs2() {
        // Lombok的@NonNull使用
        new NonNullTest("cs");
        // java.lang.NullPointerException: name is marked non-null but is null
        // 标记为非空，但是为空！
        new NonNullTest(null);
    }

    @Test
    public void cs3() throws IOException {
        // Lombok的@Cleanup使用
        // 输入输出流,无需编写try catch和调用close()方法
        String inStr = "Hello World!";
        @Cleanup ByteArrayInputStream in = new ByteArrayInputStream(inStr.getBytes("UTF-8"));
        @Cleanup ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            // 输入流
            out.write(b, 0, r);
        }
        // 输出流
        String outStr = out.toString("UTF-8");
        System.out.println(outStr);
    }

    //自动抛出异常，无需处理
    //@SneakyThrows(UnsupportedEncodingException.class)
    @SneakyThrows
    public static byte[] str2byte(String str) {
        return str.getBytes("UTF-8");
    }

    public static void main(String[] args) {
        String str = "Hello World!";
        System.out.println(str2byte(str).length);
    }
}

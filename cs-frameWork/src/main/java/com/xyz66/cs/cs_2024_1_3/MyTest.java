package com.xyz66.cs.cs_2024_1_3;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/3 9:32
 */
public class MyTest {
    @Test
    public void test1() {
        //JSON.to测试
        String jsonString = "{\"name\":\"张三\",\"age\":18}";
        String jsonString1 = "{\"status\":\"success\",\"data\":{\"name\":\"张三\",\"age\":18}}";
//        Student student = JSON.to(Student.class, jsonString);
        Student student = JSON.parseObject(jsonString1, Student.class);
        System.out.println(student);
        // 获取json对象中的属性
        JSONObject jsonObject = JSON.parseObject(jsonString1);
        Student student1 = JSON.to(Student.class, jsonObject.get("data"));
        System.out.println(jsonObject.get("data"));
        System.out.println("JSON.to:"+student1);
    }
    @Test
    public void test2() {
        //Collections.emptyList测试
        List<Object> objects = Collections.emptyList();
        System.out.println(objects);
    }
    @Test
    public void test3() {
        
        List<String> list = new ArrayList<>();
        list.add("测试清空");
        System.out.println(list);
        list.clear();// 清空集合
        System.out.println(list);
    }
}

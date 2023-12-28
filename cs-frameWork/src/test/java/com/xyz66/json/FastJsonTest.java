package com.xyz66.json;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Gjkt
 * @description FastJson测试
 * @since 2023/12/28 14:43
 */
@Log4j2
public class FastJsonTest {

    @Test
    public void test1() {
        // JSON转对象-parseObject
        String jsonString = "{\"name\":\"张三\",\"age\":18}";
        Student student = JSON.parseObject(jsonString, Student.class);
        log.info(JSON.toJSONString(student));
    }

    @Test
    public void test2() {
        // json转list-parseArray
        String jsonString = "[{\"name\":\"张三\",\"age\":18},{\"name\":\"李四\",\"age\":19}]";
        List<Student> students = JSON.parseArray(jsonString, Student.class);
        for (Student student : students) {
            log.info(JSON.toJSONString(student));
        }
    }

    @Test
    public void test3() {
        // 对象转JSON
        Student student = new Student();
        student.setName("Gjkt");
        student.setAge(3);
        log.info(JSON.toJSONString(student));
    }

    @Test
    public void test4() {
        // list转JSON
        List<Student> list = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setName("张三");
        student2.setName("李四");
        student1.setAge(3);
        student2.setAge(6);
        Collections.addAll(list, student1, student2);
        log.info(JSON.toJSONString(list));
    }

    // -----------------JSONObject-来自fastJson2----------------------
    @Test
    public void test5() {
        // JSON转JSONObject
        String jsonString = "{\"name\":\"张三\",\"age\":18}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        log.info(JSON.toJSONString(jsonObject));
    }

    @Test
    public void test6() {
        // JSONObject转JSON
        String jsonString = "{\"name\":\"张三\",\"age\":18}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String name = jsonObject.getString("name");
        log.info(name);
    }

    @Test
    public void test7() {
        // JSONObject转List(JSONObject->String->List)
        String jsonString = "[{\"name\":\"张三\",\"age\":18},{\"name\":\"李四\",\"age\":19}]";
//        log.info(t);
        List<Student> list = JSONArray.parseArray(jsonString, Student.class);
        for (Student student : list) {
            log.info(student.toString());
        }
        log.info(JSON.toJSONString(list));
    }

    @Test
    public void test8() {
        // Map转JSONObject
        Map<String, Student> map = new HashMap<>();
        //
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setName("张三");
        student2.setName("李四");
        student1.setAge(3);
        student2.setAge(6);
        //
        map.put("one", student1);
        map.put("two", student2);
        JSONObject json = (JSONObject) JSON.toJSON(map);
        log.info(json);
    }

    @Test
    public void test9() {
        String jsonString = "{\"name-cs\":\"张三\",\"age-cs\":18}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        Student student = JSON.to(Student.class, jsonObject);
        log.info(student);
    }

}

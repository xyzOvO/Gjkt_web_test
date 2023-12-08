package com.xyz66.utils;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz66.redis.pojo.User;

public class JsonUtils {

    // 对象转化为JSON String
    public static String objectToJson(Object object) {  
        // 创建 ObjectMapper 对象  
        ObjectMapper mapper = new ObjectMapper();  
        try {  
            // 将对象转化为JSON字符串  
            String json = mapper.writeValueAsString(object);  
            return json;  
        } catch (JsonProcessingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    // JSON String转化为对象
    public static <T> T jsonToObject(String json, Class<T> clazz) {  
        ObjectMapper mapper = new ObjectMapper();  
        try {  
            // 将JSON字符串转化为对象  
            T object = mapper.readValue(json, clazz);  
            return object;  
        } catch (JsonProcessingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    public static void main(String[] args) {
        // 自己造轮子
        String json = "{\"name\":\"张三\",\"age\":20}";
        User user = JsonUtils.jsonToObject(json, User.class);
        System.out.println(user);
        // fastjson2内置
        User to = JSON.to(User.class, json);
        System.out.println(to);
        // 修正测试完毕
    }
}

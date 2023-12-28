package com.xyz66.cs.cs_2023_12_28;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;  
  
public class TestJsonIgnoreProperties {  
    public static void main(String[] args) {  
        User user = new User();  
        user.setName("Alice");  
//        user.setAge(30);  
  
        try {  
            ObjectMapper mapper = new ObjectMapper();  
            String jsonString = mapper.writeValueAsString(user); // 序列化  
            System.out.println("Serialized JSON: " + jsonString);
            JSONObject jsonObject = JSON.parseObject(jsonString);
            String name = (String) jsonObject.get("name");
            System.out.println("获取名字："+name);
            User deserializedUser = mapper.readValue(jsonString, User.class); // 反序列化  
            System.out.println("Deserialized User: " + deserializedUser);
//            System.out.println(JSON.toJSONString(user));
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
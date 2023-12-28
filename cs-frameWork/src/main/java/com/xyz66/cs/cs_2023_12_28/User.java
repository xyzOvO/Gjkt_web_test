package com.xyz66.cs.cs_2023_12_28;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;  
  
@JsonIgnoreProperties(ignoreUnknown = true)  
public class User {  
    private String name;  
//    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
    // getters and setters  
}
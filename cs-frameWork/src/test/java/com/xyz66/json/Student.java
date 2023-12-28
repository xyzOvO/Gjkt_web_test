package com.xyz66.json;

import lombok.Data;

/**
 * @author Gjkt
 * @description
 * @since 2023/12/28 14:44
 */
@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

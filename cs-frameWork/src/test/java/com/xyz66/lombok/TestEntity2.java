package com.xyz66.lombok;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(fluent = true)
public class TestEntity2 implements Serializable {
    private String name;
    private String age;
    public static void main(String[] args) {
        TestEntity2 testEntity2 = new TestEntity2();
        testEntity2.name("张三")
               .age("18");
        System.out.println(testEntity2);
    }
}

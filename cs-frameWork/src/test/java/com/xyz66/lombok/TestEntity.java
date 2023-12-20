package com.xyz66.lombok;

import lombok.Builder;


@Builder
public class TestEntity {
    private String name;
    private String age;

    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity("@Value","3");
//        TestEntity testEntity2 = new TestEntity();
//        testEntity.setName("张三");
//        testEntity.setAge("18");
//        testEntity2.setName("张三");
//        testEntity2.setAge("18");
        // 测试toString
//        System.out.println(testEntity.toString());
        // 测试equals
//        System.out.println(testEntity.equals(testEntity2));

        TestEntity build = TestEntity.builder()
                .name("张三")
                .age("18")
                .build();
        System.out.println(build);
    }
}

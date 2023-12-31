package com.xyz66.json;

import javax.validation.Valid;

/**
 * @author Gjkt
 * @description
 * @since 2023/12/31 11:26
 */
//@SpringBootTest
@Valid
public class StudentTest {
    public static void test(@Valid String s) {
        Student student = new Student();
        student.setName(s);
    }

    public static void main(String[] args) {
        test(null);
    }
}

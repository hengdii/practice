package com.jiaty.demo.test.stream;

import com.alibaba.fastjson.JSON;
import com.jiaty.demo.mybatis.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tengyu5
 * @date: 2021/09/07
 **/

public class StreamMapTest {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setSname("123");
        student.setSage(1);

        Student student1 = new Student();
        student1.setSname("123");
        student1.setSage(4);

        Student student2 = new Student();
        student2.setSname("1234");
        student2.setSage(1);

        Student student3 = new Student();
        student3.setSname("123");
        student3.setSage(2);

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        List<String> collect = students.stream().map(Student::getSname).collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));

    }
}
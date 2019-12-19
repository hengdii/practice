package com.jiaty.demo.test.date20191202;

/**
 * @program: Practice
 * @description:
 * @author: jiaty
 * @create: 2019-12-02 14:15
 **/


public class Person {

    private String name;

    private Integer Age;

    public Person(String name, Integer age) {
        this.name = name;
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
package com.jiaty.demo.date20191127;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @program: Practice
 * @description: 测试
 * @author: jiaty
 * @create: 2019-11-27 11:49
 **/

public class Person {

    private String name;

    private String sex;

    private Integer age;


    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public Person(String name, String sex, Integer age, Integer status) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.status = status;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public Person(String name, String sex, Integer status) {
        this.name = name;
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
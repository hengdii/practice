package com.jiaty.demo.test.testModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: practice
 * @description:
 * @author: jiaty
 * @create: 2019-12-26 09:58
 **/

@Data
@AllArgsConstructor
public class Person {

    private String name;

    private Integer age;

    private Boolean sex;

    private BigDecimal price;

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){

    }

    public static Person newInstance(String name, Integer age, Boolean sex) {
        return new Person(name, age, sex);
    }

}
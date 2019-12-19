package com.jiaty.demo.date20191209;

/**
 * @program: Practice
 * @description:
 * @author: jiaty
 * @create: 2019-12-02 14:15
 **/


public class Person {

    private String name;

    private Integer Age;

    private Boolean flg;

    private Person(String name, Integer age,Boolean flg) {
        this.name = name;
        Age = age;
        this.flg = flg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlg() {
        return flg;
    }

    public void setFlg(Boolean flg) {
        this.flg = flg;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }


    public static Person newInstance(String name, Integer age,Boolean flg){
        return new Person(name,age,flg);
    }

}
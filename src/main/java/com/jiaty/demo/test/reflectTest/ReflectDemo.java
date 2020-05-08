package com.jiaty.demo.test.reflectTest;

import com.jiaty.demo.test.testModel.Person;

/**
 * @program: Practice
 * @description: 反射
 * @author: jiaty
 * @create: 2019-07-31 10:58
 **/

public class ReflectDemo {


    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName()  静态方法
        Class clazz1 = Class.forName("com.jiaty.demo.test.testModel.Person");
        //2.
        Person p = new Person();
        Class clazz2 = p.getClass();
        //3
        Class clazz3 = Person.class;


        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);


        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2.equals(clazz3));


    }


}
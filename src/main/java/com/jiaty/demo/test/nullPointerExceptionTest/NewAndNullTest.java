package com.jiaty.demo.test.nullPointerExceptionTest;

import com.jiaty.demo.test.testModel.Person;

/**
 * @program: Practice
 * @description: new一个对象和对象为null的区别
 * @author: jiaty
 * @create: 2019-12-10 16:45
 **/

public class NewAndNullTest {

    public static void main(String[] args) {

        Person p = new Person();
//        p =null;
        System.out.println(p.getAge());

        Person p1 = new Person();
        System.out.println(p == null);


    }


}
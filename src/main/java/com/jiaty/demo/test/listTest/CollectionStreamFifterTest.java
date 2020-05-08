package com.jiaty.demo.test.listTest;

import com.jiaty.demo.test.testModel.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Practice
 * @description: 测试JAVA集合中stream类中的 fifter
 * @author: jiaty
 * @create: 2019-11-27 11:48
 **/

public class CollectionStreamFifterTest {


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person0 = new Person("123", 22, true);
        Person person1 = new Person("123", 23, true);
        Person person2 = new Person("123", 23, true);
        Person person3 = new Person("123", 23, false);
        personList.add(person0);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

//        System.out.println(personList);

        personList.stream().filter(result -> result.getAge() == 22 || result.getAge() == 23).forEach(result -> {
//            System.out.println(1111);
            System.out.println(result.getAge());
        });

    }


}
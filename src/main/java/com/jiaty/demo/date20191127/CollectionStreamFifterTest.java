package com.jiaty.demo.date20191127;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Practice
 * @description: 测试JAVA集合中stream类中的 fifter
 * @author: jiaty
 * @create: 2019-11-27 11:48
 **/

public class CollectionStreamFifterTest {


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person0 = new Person("123","男",22,1);
        Person person1 = new Person("123","男",23,1);
        Person person2 = new Person("123","男",23,1);
        Person person3 = new Person("123","男",6);
        personList.add(person0);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        System.out.println(personList);

        List<Person> collect = personList.stream().filter(result -> result.getStatus() == 1)
                .filter(result -> result.getAge() != 23)
                .collect(Collectors.toList());

        System.out.println(collect);
    }




}
package com.jiaty.demo.test.listTest;

import com.jiaty.demo.test.testModel.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Practice
 * @description: lambda表达式的使用
 * @author: jiaty
 * @create: 2019-12-02 14:02
 **/

public class lambdaTest {


    public static List<Person> PersonLists() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person p = new Person(i + "儿子", 8 - i);
            people.add(p);
        }
        return people;
    }

    public static void main(String[] args) {

        Boolean b = true;
        Boolean aBoolean = Boolean.valueOf(false);

        List<Person> persons = PersonLists();
        persons.stream().filter(person -> person.equals("1")).collect(Collectors.toList());


    }


}
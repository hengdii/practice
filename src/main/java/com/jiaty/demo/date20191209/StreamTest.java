package com.jiaty.demo.date20191209;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Practice
 * @description: 测试strean中fifter之后数组为null会不会报错
 * @author: jiaty
 * @create: 2019-12-09 12:57
 **/

public class StreamTest {

    public static void main(String[] args) {

        Person p = Person.newInstance("10", 20, true);
        Person p1 = Person.newInstance("10", 20, true);
        Person p2 = Person.newInstance("10", 20, true);
        Person p3 = Person.newInstance("10", 20, true);
        Person p4 = Person.newInstance("10", 20, true);
        List<Person> people = new ArrayList<>(5);
        people.add(p);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);


        people.stream().filter(person -> person.getFlg().equals(false))
                .forEach(person -> {
                    if (person == null){
                        System.out.println("null");
                    }
                    System.out.println(person.getName());
                });


    }


}
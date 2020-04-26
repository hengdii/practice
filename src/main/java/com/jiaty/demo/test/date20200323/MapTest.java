package com.jiaty.demo.test.date20200323;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-03-24 18:34
 **/

public class MapTest {

    public static void main(String[] args) {

        Map<Integer,Person> personMap = new HashMap<>();
        Person person = new Person();
        person.setAge(1);
        personMap.put(1,person);

        Person person1 = personMap.get(2);
//        if (person1 == null){
//            person1 = new Person();
//        }
        person1.setName("123");
        personMap.put(2,person1);

        System.out.println(JSON.toJSONString(personMap));

    }




}
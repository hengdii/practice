package com.jiaty.demo.test.mapTest;

import com.alibaba.fastjson.JSON;
import com.jiaty.demo.test.testModel.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: practice
 * @description: list作为map中的value
 * @author: jiaty
 * @create: 2019-12-26 09:57
 **/

public class ListInMapTest {

    public static void main(String[] args) {
        /**
         * 可以看出，将值从map中取出来作为一个临时变量。对他进行值得修改，就相当于对map的值进行修改
         */
        List<Person> p = new ArrayList<>();
        Person p1 = new Person("张三",3,true);
        p.add(p1);
        Map<Integer,List<Person>> map = new HashMap<>();
        map.put(1,p);
        for (int i =0;i<map.size();i++){
            List<Person> people = map.get(1);
            Person p2 = new Person("张四",4,true);
            people.add(p2);
        }
        System.out.println(JSON.toJSONString(map));


    }



}
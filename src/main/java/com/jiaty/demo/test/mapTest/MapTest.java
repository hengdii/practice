package com.jiaty.demo.test.mapTest;

import com.alibaba.fastjson.JSON;
import com.jiaty.demo.test.testModel.Person;

import java.math.BigDecimal;
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

        //测试getMap
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);

        Integer i;
        i = map.get(3);
        System.out.println(i);


        Map<Integer, Person> personMap = new HashMap<>();
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


        Map<Integer, BigDecimal> map1 = new HashMap<>();
        map1.put(1,BigDecimal.TEN);

        BigDecimal bigDecimal = map1.get(2);
        if (bigDecimal == null){
            bigDecimal = BigDecimal.ZERO;
        }
        map1.put(2,bigDecimal);
        System.out.println(map1);
    }




}
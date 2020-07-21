package com.jiaty.demo.test.mapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Practice
 * @description: keySet
 * @author: Jiaty
 * @create: 2020-02-10 11:29
 **/

public class KeySetTest {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>(3);
        map.put(11,"1");
        map.put(22,"2");
        map.put(33,"3");
        map.keySet().forEach(System.out::println);



    }



}
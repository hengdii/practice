package com.jiaty.demo.test.date20200304;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Practice
 * @description: 测试getMap
 * @author: Jiaty
 * @create: 2020-03-04 16:57
 **/

public class MapTest {

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);

        Integer i;
        i = map.get(3);
        System.out.println(i);

    }


}
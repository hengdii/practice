package com.jiaty.demo.test.date20191209;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Practice
 * @description: 测试空的map，能否用containsKey的方法
 * @author: jiaty
 * @create: 2019-12-09 17:33
 **/

public class MapNullTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map = null;

        if (map != null && map.containsKey("12312")) {
            System.out.println(1);
        }


    }

}
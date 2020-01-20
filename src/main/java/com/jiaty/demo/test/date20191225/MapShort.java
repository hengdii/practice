package com.jiaty.demo.test.date20191225;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @program: practice
 * @description: short在Map中的转化
 * @author: jiaty
 * @create: 2019-12-25 14:43
 **/

public class MapShort {

    public static void main(String[] args) {

        Short s = 6;

        Map map = Maps.newHashMap();
        map.put("s",s);

        if ("6".equals(map.get("s").toString())){
            System.out.println("耶耶耶");
        }


    }

}
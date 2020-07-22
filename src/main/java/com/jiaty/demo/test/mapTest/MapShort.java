package com.jiaty.demo.test.mapTest;

//import com.google.common.collect.Maps;

import java.util.HashMap;
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

//        Map map = Maps.newHashMap();
        Map map = new HashMap();
        map.put("s",s);

        if ("6".equals(map.get("s").toString())){
            System.out.println("耶耶耶");
        }


    }

}
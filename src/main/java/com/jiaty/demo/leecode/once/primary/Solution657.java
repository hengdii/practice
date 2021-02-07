package com.jiaty.demo.leecode.once.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: practice
 * @description: 机器人能否返回原点
 * @author: Jiaty
 * @create: 2020-08-28 00:23
 **/

public class Solution657 {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('U', 0);
        map.put('D', 0);
        map.put('R', 0);
        map.put('L', 0);
    }

    public static boolean judgeCircle(String moves) {
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            Integer integer = map.get(c);
            integer += 1;
            map.put(c, integer);
        }
        return map.get('U').equals(map.get('D')) && map.get('R').equals(map.get('L'));
    }

    public static void main(String[] args) {
        String moves = "UDRL";
        System.out.println(judgeCircle(moves));
    }


}
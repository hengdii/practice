package com.jiaty.demo.leecode.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-10-28 10:18
 **/

public class Solution1207 {

    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arrMap.values()) {
            if (map.get(i) != null) {
                return false;
            }
            map.put(i, 1);
        }
        return true;
    }


}
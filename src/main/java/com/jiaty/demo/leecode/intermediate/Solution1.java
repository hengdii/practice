package com.jiaty.demo.leecode.intermediate;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: practice
 * @description: 两数之和
 * @author: Jiaty
 * @create: 2020-12-28 11:40
 **/

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
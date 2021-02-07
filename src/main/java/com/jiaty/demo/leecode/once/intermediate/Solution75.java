package com.jiaty.demo.leecode.once.intermediate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: practice
 * @description: 颜色分类
 * @author: Jiaty
 * @create: 2020-09-02 18:07
 **/

public class Solution75 {

    public static void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(3);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int i0 = map.getOrDefault(0, 0);
        int i1 = map.getOrDefault(1, 0);
        for (int i = 0; i < i0; i++) {
            nums[i] = 0;
        }
        for (int i = i0; i < i1 + i0; i++) {
            nums[i] = 1;
        }
        for (int i = i1 + i0; i < nums.length; i++) {
            nums[i] = 2;
        }
    }





    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
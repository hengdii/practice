package com.jiaty.demo.leecode.intermediate;

import java.util.*;

/**
 * @program: practice
 * @description: 前K个高频元素
 * @author: Jiaty
 * @create: 2020-09-02 10:52
 **/

public class Solution347 {
    /**
     * 存在一个bug，无法应对数组中有负数的情况，一旦有负数，没办法做数组下标，list[]那边会报错
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (int i : map.keySet()) {
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(map.get(i));
        }
        int[] result = new int[k];
        for (int j = 0; j < result.length; ) {
            for (int i = nums.length; i > -1; i--) {
                if (list[i] == null) {
                    continue;
                }
                for (int l = 0; l < list[i].size(); l++) {
                    if (j == result.length) {
                        break;
                    }
                    result[j++] = list[i].get(l);
                }
            }
        }
        return result;
    }


    /**
     * 看了大佬的解法，更改了一下写法，之前的key和value都不对
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        //key:key是数组中的数字，value是出现的次数
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //桶排序
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (list[value] == null) {
                list[value] = new ArrayList<>();
            }
            list[value].add(key);
        }
        int[] result = new int[k];
        for (int j = 0; j < result.length; ) {
            for (int i = nums.length; i > -1; i--) {
                if (list[i] == null) {
                    continue;
                }
                for (int l = 0; l < list[i].size(); l++) {
                    //还有一种想法，就是直接把数字全都添加进来，然后截取前K个。算是很正常的排序
                    if (j == result.length) {
                        break;
                    }
                    result[j++] = list[i].get(l);
                }
            }
        }
        return result;
    }

    /**
     * 大佬写法
     * <p>
     * 桶排序
     */

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        System.out.println(Arrays.toString(topKFrequent1(nums, k)));
    }
}
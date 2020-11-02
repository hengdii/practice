package com.jiaty.demo.leecode.primary;

import java.util.*;

/**
 * @program: practice
 * @description: 两个数组的交集
 * @author: Jiaty
 * @create: 2020-11-02 10:02
 **/

public class Solution349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{4, 4, 8, 9, 9};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }
}
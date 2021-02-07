package com.jiaty.demo.leecode.once.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: practice
 * @description: 三数之和
 * @author: Jiaty
 * @create: 2020-08-14 17:52
 **/

public class Solution15 {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        //先排序
        Arrays.sort(nums);
        //从中间开始切分
        int start = 0;
        int end = nums.length - 1;
        int mid = end / 2;
        // 当数组中没有解的时候，会陷入死循环，mid在中间一直加减 TODO Wrong
        while (start < end) {
            if (mid == start) {
                end--;
                mid = (start + end) / 2;
            } else if (mid == end) {
                start++;
                mid = (start + end) / 2;
            } else {
                if (nums[start] + nums[end] > 0) {
                    if (nums[start] + nums[end] + nums[mid] == 0) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        list.add(nums[mid]);
                        lists.add(list);
                    }
                    mid--;
                } else if (nums[start] + nums[end] < 0) {
                    if (nums[start] + nums[end] + nums[mid] == 0) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        list.add(nums[mid]);
                        lists.add(list);
                    }
                    mid++;
                } else {
                    if (nums[mid] > 0) {
                        mid--;
                    } else if (nums[mid] < 0) {
                        mid++;
                    } else {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        list.add(nums[mid]);
                        lists.add(list);
                        start++;
                        end--;
                    }
                }
            }
        }
        return lists;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -2, -1};
//        System.out.println(threeSum(nums));
        System.out.println(threeNum1(nums));
    }


    public static List<List<Integer>> threeNum1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
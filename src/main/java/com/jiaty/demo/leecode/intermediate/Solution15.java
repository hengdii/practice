package com.jiaty.demo.leecode.intermediate;

import java.util.ArrayList;
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
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        //先排序
        //从中间开始切分

        return lists;

    }


    public static void main(String[] args) {


    }


}
package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 魔术索引
 * @author: Jiaty
 * @create: 2020-07-31 16:30
 **/

public class Solution0803 {

    /**
     * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     * <p>
     * 示例1:
     * <p>
     * 输入：nums = [0, 2, 3, 4, 5]
     * 输出：0
     * 说明: 0下标的元素为0
     * 示例2:
     * <p>
     * 输入：nums = [1, 1, 1]
     * 输出：1
     * 说明:
     * <p>
     * nums长度在[1, 1000000]之间
     * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
     */

    public static int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Integer key = null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                key = i;
                break;
            }
        }
        if (key == null) {
            return -1;
        }
        return key;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,3,4,5,6};
        System.out.println(findMagicIndex(nums));
    }
}
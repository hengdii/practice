package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 非递减数列
 * @author: Jiaty
 * @create: 2020-09-10 17:21
 **/

public class Solution665 {
    /**
     * 自己写的暴力解法，不靠谱。
     * <p>
     * 想法是先找到第一个拐点。然后切分成两个数组。数组内部各自再寻找是否有拐点。然后将前一个数组的倒数第二个值和后一个数组的第一个值进行比较
     * <p>
     * 然后
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int j = 0;
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] < nums[k - 1]) {
                j = k;
            }
        }
        int[] newNums = new int[j];
        int[] newNums1 = new int[nums.length - j -1 ];
        System.arraycopy(nums, 0, newNums, 0, j);
        System.arraycopy(nums, j + 1, newNums1, 0, nums.length - j - 1);
        for (int i = 1; i < newNums.length; i++) {
            if (newNums[i] < newNums[i - 1]) {
                return false;
            }
        }
        for (int i = 1; i < newNums1.length; i++) {
            if (newNums1[i] < newNums1[i - 1]) {
                return false;
            }
        }
        if (j != 0 && newNums[j - 1] > newNums1[0]) {
            return false;
        }
        return true;
    }

    public static boolean checkPossibility1(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                sum++;
                if (sum >= 2) {
                    return false;
                }
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3};
        System.out.println(checkPossibility(nums));
    }
}
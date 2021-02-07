package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 二分查找
 * @author: Jiaty
 * @create: 2020-08-20 10:50
 **/

public class Solution704 {
    /**
     * 二分查找  模版一
     * <p>
     * 初始条件：left = 0, right = length-1
     * 终止：left > right
     * 向左查找：right = mid-1
     * 向右查找：left = mid+1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int result = -1;
        if (nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
//
//        int target = 2;
//
//        System.out.println(search(nums, target));
//
//        int x = 8000;
//        System.out.println(mySqrt(x));

        int n = 3;
        System.out.println(guessNumber1(n));
        System.out.println(guessNumber(n));
    }


    public static int mySqrt(int x) {
        int start = 0;
        int end = x;

        return -1;
    }


    public static int guessNumber(int n) {
        if (guess(n) == 0) {
            return n;
        }
        int i = 1;
        int end = n - 1;
        while (i <= n) {
            int mid = i + (end - i) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) > 0) {
                i = mid - 1;
            } else {
                end = mid + 1;
            }
        }
        return -1;
    }


    public static int guessNumber1(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) > 0) {
                low = mid - 1;
            } else {
                high = mid + 1;
            }
        }
        return -1;
    }


    private static int guess(int n) {
        return n == 1 ? 0 : n > 1 ? -1 : 1;
    }


}
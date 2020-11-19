package com.jiaty.demo.leecode.primary;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 奇偶数排序
 * @author: Jiaty
 * @create: 2020-11-12 10:15
 **/

public class Solution922 {
    /**
     * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
     * <p>
     * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
     */
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int[] ans = new int[length];

        int i = 0;
        int j = 1;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[i] = x;
                i += 2;
            } else {
                ans[j] = x;
                j += 2;
            }
        }
        return ans;
    }


    /**
     * 双指针
     */
    public static int[] sortArrayByParityII1(int[] A) {
        int len = A.length;
        int i = 1;
        for (int j = 0; j < len; j += 2) {
            if (A[j] % 2 == 1) {
                while (A[i] % 2 == 1) {
                    i += 2;
                }
                swap(A, j, i);
            }
        }
        return A;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args) {
        int[]A = new int[]{1,4,5,6,7,10,11,12};
        System.out.println(Arrays.toString(sortArrayByParityII1(A)));
    }


}
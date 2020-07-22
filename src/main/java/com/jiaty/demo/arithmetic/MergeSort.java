package com.jiaty.demo.arithmetic;

import java.util.Arrays;

/**
 * @program: Practice
 * @description: 归并排序
 * @author: Jiaty
 * @create: 2020-07-21 16:57
 **/

public class MergeSort {

    public static int[] mergeSort(int[] nums, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[10];
        int[] R = new int[10];

        for (int i = 0; i < n1; i++) {
            L[i] = nums[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = nums[q + j + 1];
        }
        //哨兵
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        for (int k = p; k < r; k++) {
            if (L[i] > R[j]) {
                nums[k] = R[j];
                j = j + 1;
            } else {
                nums[k] = L[i];
                i = i + 1;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] A = new int[]{2, 4, 5, 6, 1, 3, 7, 9};
        int p = 0;
        int q = 3;
        int r = 7;
        System.out.println(Arrays.toString(mergeSort(A, p, q, r)));


    }


    /**
     *  一旦数组L或者R的所有元素都被复制回A就立即停止，然后把另一个数组的剩余部分复制回A
     *
     * @param nums
     * @param p
     * @param q
     * @param r
     * @return
     */
    public static int[] mergeSort1(int[] nums, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[10];
        int[] R = new int[10];

        for (int i = 0; i < n1; i++) {
            L[i] = nums[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = nums[q + j + 1];
        }
//        L[n1] = Integer.MAX_VALUE;
//        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        for (int k = p; k < r; k++) {
            if (L[i] > R[j]) {
                nums[k] = R[j];
                j = j + 1;
            } else {
                nums[k] = L[i];
                i = i + 1;
            }
        }
        return nums;
    }

}
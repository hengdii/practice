package com.jiaty.demo.arithmetic;

import java.util.Arrays;

/**
 * @program: Practice
 * @description: 插入排序
 * @author: Jiaty
 * @create: 2020-07-21 15:23
 **/

public class InsertionSort {
    /**
     * 参数是一个数组A[1..n]，包含长度为n的要排序的一个序列
     * <p>
     * 这个方法跳过了数组中的第一个值，从数组中第二个值开始排序的
     *
     * @param numsA
     * @return
     */
    public static int[] sort(int[] numsA) {
        int key = 0;
        int i = 0;
        for (int j = 2; j < numsA.length; j++) {
            key = numsA[j];
            i = j - 1;
            while (i > 0 && numsA[i] > key) {
                numsA[i + 1] = numsA[i];
                i = i - 1;
            }
            numsA[i + 1] = key;
        }
        return numsA;
    }


    public static void main(String[] args) {
        int[] a = new int[]{7, 4, 2, 6, 9, 8, 8, 3, 5};

        System.out.println(Arrays.toString(sortAll(a)));

    }


    /**
     * 参数是一个数组A[n1..n]，包含长度为n的要排序的一个序列
     * <p>
     * 这个方法就是对数组中的所有数值都进行排序，从小到大排序
     *
     * @param numsA
     * @return
     */
    public static int[] sortAll(int[] numsA) {
        int key = 0;
        int i = 0;
        for (int j = 1; j < numsA.length; j++) {
            key = numsA[j];
            i = j - 1;
            while (i >= 0 && numsA[i] > key) {
                numsA[i + 1] = numsA[i];
                i = i - 1;
            }
            numsA[i + 1] = key;
        }
        return numsA;
    }

}
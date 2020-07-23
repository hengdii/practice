package com.jiaty.demo.leeCode.primary;

/**
 * @program: Practice
 * @description: 旋转数组的最小数字
 * @author: Jiaty
 * @create: 2020-07-22 13:56
 **/

public class SolutionOffer11 {
    /**
     * 题目：
     *   把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
     */


    /**
     * 自己写的暴力写法，没有读懂题目的意思，其实主要是没看懂数组的旋转是什么就上手答题了。这个的写法主要是没考虑到旋转的问题，就是单纯的去找到数组中最小的值
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int key = numbers[i];
            while (i >= 0 && key > numbers[i + 1]) {
                numbers[i] = numbers[i + 1];
                i = i - 1;
            }
        }
        return numbers[0];
    }


    /**
     * 正确的写法看到这样的排序，应该第一时间想到二分查找。
     *
     * @param numbers
     * @return
     */
    public static int minArray1(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            //这一步就写错了， 不应该用mid和mid+1去比较
            if (numbers[mid] > numbers[mid + 1]) {
                return numbers[mid + 1];
            }
            j--;

        }
        return numbers[0];

    }


    public static void main(String[] args) {
        int[] numbers = new int[]{3, 1, 2, 2, 2};
        System.out.println(minArray1(numbers));
    }

    /**
     * 官方
     * @param numbers
     * @return
     */
    public static int minArray2(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (numbers[mid] < numbers[end]) {
                end = mid;
            } else if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else {
                end -= 1;
            }
        }
        return numbers[start];
    }

}
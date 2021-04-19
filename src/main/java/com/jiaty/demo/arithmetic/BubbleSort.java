package com.jiaty.demo.arithmetic;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 冒泡排序
 * @author: Jiaty
 * @create: 2020-08-31 10:39
 **/

public class BubbleSort {


    // 冒泡排序，a表示数组，n表示数组大小
    public static int[] bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return a;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{4,5,6,3,2,1};
        System.out.println(Arrays.toString(bubbleSort(nums, nums.length)));
    }


}
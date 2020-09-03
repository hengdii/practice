package com.jiaty.demo.leecode.intermediate;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: practice
 * @description: 无重叠空间
 * @author: Jiaty
 * @create: 2020-09-03 14:31
 **/

public class Solution435 {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];   //终点位从小到大
            }
        });
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }


    public static int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //lambda表达式
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];   //终点位从小到大
        });
//        先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
//
//        在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
//
//        按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。

        //为什么要用区间的结尾排序，因为题目说可以一直认为【start  , end 】 end > start。
        // 在这个前提下，如果是这种情况[3,7],[2,8] 那第二个也会被pass。总的来说就是想要每个[]中间距离最小
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }


    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{1, 2};
        intervals[1] = new int[]{3, 7};
        intervals[2] = new int[]{2, 8};
        intervals[3] = new int[]{7, 10};
//        for (int i = 0; i < intervals.length; i++) {
//            System.out.print(Arrays.toString(intervals[i]));
//        }
        System.out.println("---------------------");
        System.out.println(eraseOverlapIntervals(intervals));
        System.out.println("---------------------");
//        for (int i = 0; i < intervals.length; i++) {
//            System.out.print(Arrays.toString(intervals[i]));
//        }
    }
}
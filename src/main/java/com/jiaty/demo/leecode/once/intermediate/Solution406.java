package com.jiaty.demo.leecode.once.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: practice
 * @description: 根据身高重建队列
 * @author: Jiaty
 * @create: 2020-09-08 17:05
 **/

public class Solution406 {

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < people.length; i++) {
            System.out.println("第一次" + "---------" + Arrays.toString(people[i]));
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[1] - o2[1];
            }
        });
        return people;
    }


    public static int[][] reconstructQueue1(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
//
//        for (int i = 0; i < people.length; i++) {
//            System.out.println("第一次" + "---------" + Arrays.toString(people[i]));
//        }

        List<int[]> outList = new LinkedList<>();
        for (int[] p : people) {
            outList.set(p[1], p);
        }
        int length = people.length;
        return outList.toArray(new int[length][2]);
    }


    public static int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        int[][] people = new int[6][2];
        people[0] = new int[]{7, 0};
        people[1] = new int[]{4, 4};
        people[2] = new int[]{7, 1};
        people[3] = new int[]{5, 0};
        people[4] = new int[]{6, 1};
        people[5] = new int[]{5, 2};
//        reconstructQueue(people);
        reconstructQueue2(people);
        int[][] queue2 = reconstructQueue1(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println("第二次" + "---------" + Arrays.toString(queue2[i]));
        }

    }


}
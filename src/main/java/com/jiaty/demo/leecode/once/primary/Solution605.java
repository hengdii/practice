package com.jiaty.demo.leecode.once.primary;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: practice
 * @description: 种花问题
 * @author: Jiaty
 * @create: 2020-09-10 13:22
 **/

public class Solution605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> list = new LinkedList<>();
        List<Integer> sumlist = new LinkedList<>();
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                list.add(i);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            sumlist.add(list.get(i) - list.get(i - 1));
        }
        int sum = 0;
        for (Integer i : sumlist) {
            sum += i / 2 - 1;
        }
        return sum >= n;
    }


    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }


    public static void main(String[] args) {
//        System.out.println(4 / 3);
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
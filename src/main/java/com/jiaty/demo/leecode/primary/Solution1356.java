package com.jiaty.demo.leecode.primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: practice
 * @description: 根据数字二进制下的1的数目排序
 * @author: Jiaty
 * @create: 2020-11-06 14:19
 **/

public class Solution1356 {
    /**
     * 暴力解法
     */
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
            bit[x] = getOne(x);
        }
        list.sort((x, y) -> {
            if (bit[x] != bit[y]) {
                return bit[x] - bit[y];
            } else {
                return x - y;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int getOne(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }


    /**
     * 递推解法
     */
    public int[] sortByBits1(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int x : arr) {
            list.add(x);
        }
        int[] bit = new int[10001];
        for (int i = 0; i <= 10000; i++) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        list.sort((x, y) -> {
            if (bit[x] != bit[y]) {
                return bit[x] - bit[y];
            } else {
                return x - y;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 大佬解法
     */
    public int[] sortByBits2(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i] % 10000000;
        }
        return ans;
    }

}
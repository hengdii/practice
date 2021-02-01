package com.jiaty.demo.leecode.primary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: practice
 * @description: 公平的糖果棒交换
 * @author: Jiaty
 * @create: 2021-02-01 18:01
 **/

public class Solution888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
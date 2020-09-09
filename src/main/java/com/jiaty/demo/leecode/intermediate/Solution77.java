package com.jiaty.demo.leecode.intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description: 组合
 * @author: Jiaty
 * @create: 2020-09-09 14:36
 **/

public class Solution77 {

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * <p>
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */


    public static List<List<Integer>> combine(int n, int k) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int start = 1; start < n; start++) {
            dfs(lists, list, start, n, k);
        }
        return new ArrayList<>();
    }


    private static void dfs(List<List<Integer>> lists, List<Integer> list, int start, int n, int k) {


    }


}
package com.jiaty.demo.leecode.intermediate;

import java.util.*;

/**
 * @program: practice
 * @description: 组合总和
 * @author: Jiaty
 * @create: 2020-09-09 10:45
 **/

public class Solution39 {

//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        Set<List<Integer>> combinationSum = new HashSet<>();
//        Arrays.sort(candidates);
//        int rest = target;
//
//
////        while (rest != 0) {
////            List<Integer> list = new ArrayList<>();
////            for (int i = candidates.length - 1; i > -1; i--) {
////                if (candidates[i] == rest) {
////                    list.add(candidates[i]);
////                    combinationSum.add(list);
////                    break;
////                } else if (candidates[i] < rest) {
////                    rest = target - candidates[i];
////                    list.add(candidates[i]);
////                }
////            }
////        }
//        return new ArrayList<>(combinationSum);
//    }
//
//    private static void addInt(int[] candidates, int rest, List<List<Integer>> lists) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = candidates.length - 1; i > -1; i--) {
//            if (candidates[i] == rest) {
//                list.add(candidates[i]);
//                combinationSum.add(list);
//                break;
//            } else if (candidates[i] < rest) {
//                rest = target - candidates[i];
//                list.add(candidates[i]);
//            }
//        }
//    }

    /**
     * 官方题解：回溯算法
     *
     *
     *
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum1(candidates, target));

    }
}
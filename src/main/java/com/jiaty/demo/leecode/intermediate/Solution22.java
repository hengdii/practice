package com.jiaty.demo.leecode.intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description: 括号生成
 * @author: Jiaty
 * @create: 2020-10-12 17:50
 **/

public class Solution22 {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        for (String s : list) {
            System.out.println(s);
        }
    }


    public static List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();

        if (n == 0) {
            return ans;
        }
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void dfs(String cur, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(cur + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(cur + ")", left, right - 1, res);
        }


    }


}
package com.jiaty.demo.leecode.primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description: 二叉搜索树中的众数
 * @author: Jiaty
 * @create: 2020-09-24 10:31
 **/

public class Solution501 {

    int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
//    public int[] findMode(TreeNode root) {
//
//    }


    private static class TreeNode {
        int val;
        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right =new TreeNode(4);
    }
}
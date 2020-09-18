package com.jiaty.demo.leecode.intermediate;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: practice
 * @description: 不同的二叉搜索树 II
 * @author: Jiaty
 * @create: 2020-09-18 14:50
 **/

public class Solution95 {
    /**
     * 官方解法
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        //枚举可行根节点
        for (int i = start; i <= end; i++) {
            //获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            //获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            //从左子树集合选出一颗左子树，从右子树集合中选出一颗右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
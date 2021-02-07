package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 合并二叉树
 * @author: Jiaty
 * @create: 2020-09-23 10:22
 **/

public class Solution617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode treeNode = new TreeNode(0);
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            treeNode.val = t2.val;
            treeNode.left = mergeTrees(null, t2.left);
            treeNode.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            treeNode.val = t1.val;
            treeNode.left = mergeTrees(t1.left, null);
            treeNode.right = mergeTrees(t1.right, null);
        } else {
            treeNode.val = t1.val + t2.val;
            treeNode.left = mergeTrees(t1.left, t2.left);
            treeNode.right = mergeTrees(t1.right, t2.right);
        }
        return treeNode;
    }

    /**
     * 升级版
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees1(t1.left, t2.left);
        treeNode.right = mergeTrees1(t1.right, t2.right);
        return treeNode;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
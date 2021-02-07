package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 二叉搜索树的绝对最小差
 * @author: Jiaty
 * @create: 2020-10-12 10:41
 **/

public class Solution530 {


    /**
     * 二叉搜索树，本身经过中序遍历就可以成为一个有序的序列
     * <p>
     * 在二叉搜索树中：
     * 1.若任意结点的左子树不空，则左子树上所有结点的值均不大于它的根结点的值。
     * 2.若任意结点的右子树不空，则右子树上所有结点的值均不小于它的根结点的值。
     * 3.任意结点的左、右子树也分别为二叉搜索树。
     */

    private static int ans;
    private static int pre;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        getMin(root);
        return ans;
    }


    private static void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMin(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        getMin(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int x) {
            val = x;
        }
    }
}
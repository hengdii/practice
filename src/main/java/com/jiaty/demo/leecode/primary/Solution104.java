package com.jiaty.demo.leecode.primary;

/**
 * @author Jiaty
 * @date 2020/7/28 23:30
 */
public class Solution104 {
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     */

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int i = 1;
        return depth(i,root);
    }

    public int depth(int i,TreeNode root){
        if (root == null){
            return i;
        }
        if (root.left == null && root.right == null){
            return i;
        }
        return Math.max(depth(i+1,root.left),depth(i+1,root.right));
    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

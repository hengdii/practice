package com.jiaty.demo.leecode.once.intermediate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: practice
 * @description: 求根到叶子结点的数字之和
 * @author: Jiaty
 * @create: 2020-10-29 10:38
 **/

public class Solution129 {

    /**
     * 深度优先遍历
     * <p>
     * 时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     * <p>
     * 空间复杂度：O(n)，其中 n 是二叉树的节点个数。空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，
     * 最坏情况下，二叉树的高度等于节点个数，空间复杂度为 O(n)。
     *
     * @param root
     * @return
     */
    public int sumNumbers_dfs(TreeNode root) {
        return dfs(root, 0);
    }


    public int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 广度优先遍历
     *
     *
     */
    public int sumNumbers_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQuene = new LinkedList<TreeNode>();
        Queue<Integer> nodeSum = new LinkedList<>();
        nodeQuene.offer(root);
        nodeSum.offer(root.val);
        while (!nodeQuene.isEmpty()) {
            TreeNode node = nodeQuene.poll();
            int num = nodeSum.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQuene.offer(left);
                    nodeSum.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQuene.offer(right);
                    nodeSum.offer(num * 10 + right.val);
                }
            }

        }
        return sum;
    }

}
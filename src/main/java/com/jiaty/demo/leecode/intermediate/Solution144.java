package com.jiaty.demo.leecode.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiaty
 * @date 2020/7/28 21:26
 */
public class Solution144 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     * <p>
     *  示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,2,3]
     * <p>
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        fillStack(stack,root);
        return new ArrayList<>(stack);
    }

    public void fillStack(Stack<Integer> stack,TreeNode root){
        if (root==null){
            return;
        }
        stack.push(root.val);
        fillStack(stack,root.left);
        fillStack(stack,root.right);
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

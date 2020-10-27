package com.jiaty.demo.leecode.intermediate;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        fillStack(list, root);
        return list;
    }

    public void fillStack(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        fillStack(list, root.left);
        fillStack(list, root.right);
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val=" + val + ", left=" + left + ", right=" + right;
        }
    }


    /**
     * 迭代
     * 先把左子点迭代空，然后把栈顶的推出，去寻找右子点
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }


    /**
     * Morris 遍历
     */

    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);


        System.out.println(preorderTraversal3(treeNode));


    }


}

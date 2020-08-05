package com.jiaty.demo.leecode.intermediate;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Practice
 * @description: 打家劫舍3 TODO
 * @author: Jiaty
 * @create: 2020-08-05 10:15
 **/

public class Solution337 {

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(tree(root), tree(root.left) + tree(root.right));
    }

    public static int tree(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        int lLeft = root.left == null ? 0 : root.left.left == null ? 0 : tree(root.left.left);
        int lLeft = root.left == null ? 0 : root.left.left == null ? 0 : Math.max(tree(root.left.left),tree(root.left.left.left) + tree(root.left.left.right));
//        int lRight = root.left == null ? 0 : root.left.right == null ? 0 : tree(root.left.right);
        int lRight = root.left == null ? 0 : root.left.right == null ? 0 : Math.max(tree(root.left.right),tree(root.left.right.left) + tree(root.left.right.right));
//        int rLeft = root.right == null ? 0 : root.right.left == null ? 0 : tree(root.right.left);
        int rLeft = root.right == null ? 0 : root.right.left == null ? 0 : Math.max(tree(root.right.left),tree(root.right.left.left) + tree(root.right.left.right));
//        int rRight = root.right == null ? 0 : root.right.right == null ? 0 : tree(root.right.right);
        int rRight = root.right == null ? 0 : root.right.right == null ? 0 : Math.max(tree(root.right.right),tree(root.right.right.left) + tree(root.right.right.right));

        return root.val + lLeft + lRight + rLeft + rRight;
    }


    private static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
//        treeNode.right = null;
        treeNode.left.left = new TreeNode(2);
//        treeNode.left.right = null;
//        treeNode.right.left = null;
//        treeNode.right.right = null;
        treeNode.left.left.left = new TreeNode(3);
        System.out.println(rob1(treeNode));
    }



    private static Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    private static Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public static int rob1(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }


    /**
     * 官方解法2，更优解
     * @param root
     * @return
     */
    public static int rob2(TreeNode root) {
        int[] rootStatus = dfs1(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public static int[] dfs1(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs1(node.left);
        int[] r = dfs1(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }


}
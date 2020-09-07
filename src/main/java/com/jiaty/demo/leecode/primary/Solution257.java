package com.jiaty.demo.leecode.primary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: practice
 * @description: 二叉树的所有路径
 * @author: Jiaty
 * @create: 2020-09-04 10:59
 **/

public class Solution257 {
    /**
     * Wrong 解决不好，重复的东西
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        binaryTree(root.left, sb.toString(), list);
        binaryTree(root.right, sb.toString(), list);
        return list;
    }

    private static void binaryTree(TreeNode root, String string, List<String> list) {
        if (root == null) {
            return;
        }
        StringBuilder append = new StringBuilder(string).append("->").append(root.val);
        if (root.right != null) {
            binaryTree(root.right, append.toString(), list);
        } else if (root.left != null) {
            binaryTree(root.left, append.toString(), list);
        } else {
            list.add(string);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(5);
//        System.out.println(binaryTreePaths(treeNode));
//        System.out.println(binaryTreePaths1(treeNode));
        System.out.println(binaryTreePaths2(treeNode));
    }

    /**
     * 深度优先搜索
     * <p>
     * 最直观的方法是使用深度优先搜索。在深度优先搜索遍历二叉树时，我们需要考虑当前的节点以及他的孩子节点
     * · 如果当前节点不是叶子节点，则在当前的路径末尾添加该节点，并继续递归遍历该节点的每一个孩子节点
     * · 如果当前节点是叶子节点，则在当前路径末尾添加该节点后我们就得到了一条从根节点到叶子节点的路径，将该路径加入到答案中即可
     * <p>
     * 如此，当遍历完整棵二叉树以后我们就得到了所有从跟节点到叶子节点的路径。当然，深度优先搜索也可以使用非递归的方式实现
     *
     * @param treeNode
     * @return
     */
    public static List<String> binaryTreePaths1(TreeNode treeNode) {
        List<String> paths = new ArrayList<>();
        constructPaths(treeNode, "", paths);
        return paths;
    }

    public static void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuilder pathsb = new StringBuilder(path);
        pathsb.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(pathsb.toString());
            return;
        }
        pathsb.append("->");
        constructPaths(root.left, pathsb.toString(), paths);
        constructPaths(root.right, pathsb.toString(), paths);
    }


    /**
     * 广度优先搜索
     * <p>
     * 我们也可以用光地优先搜索来实现，我们维护一个队列，存储节点以及根到该节点的路径。一开始这个队列里面只有根节点，在每一步迭代中
     * 我们去除队列中的首节点，如果它是叶子节点，则将它对应的路径加入到答案中。如果它不是叶子节点，则将它的所有孩子节点加入到队列的末尾。
     * 当队列为空时广度优先搜索结束，就都能得到答案
     */

    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQuene = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQuene.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQuene.isEmpty()) {
            TreeNode node = nodeQuene.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQuene.offer(node.left);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.left.val).toString());
                }
                if (node.right != null) {
                    nodeQuene.offer(node.right);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }


}
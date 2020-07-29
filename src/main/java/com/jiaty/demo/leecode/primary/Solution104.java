package com.jiaty.demo.leecode.primary;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 写的没错，但是步骤较为繁琐
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = 1;
        return depth(i, root);
    }

    public static int depth(int i, TreeNode root) {
        if (root == null) {
            return i;
        }
        if (root.left == null && root.right == null) {
            return i;
        }
        return Math.max(depth(i + 1, root.left), depth(i + 1, root.right));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 官方解法一， 更加简单的递归
     *
     * 破题思路：
     * 如果我们知道了左子树和右子树的最大深度 ll 和 rr，那么该二叉树的最大深度即为
     *
     *               ax(l,r)+1
     *
     * 而左子树和右子树的最大深度又可以以同样的方式进行计算。因此我们在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，然后在 O(1)O(1) 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出。
     *
     * 复杂度分析:
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度：O(\textit{height})O(height)，其中 \textit{height}height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
     *
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    /**
     * 官方解法二，广度优先算法 TODO（不理解）
     * 破题思路：
     *  我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
     *  每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，
     *  即我们是一层一层地进行拓展，最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为ans。
     *
     *  复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
     * 空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)O(n)。
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        //最开始 队列里只有一个根结点，然后队列先poll出了第一个元素，就是根结点，然后假如说左右子树有值的话，队列中会不断的加入新的值，同时移除最先进去的值，达到效果
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                //poll：移出队列的第一个元素
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);



    }
}

package com.jiaty.demo.leecode.once.intermediate;

/**
 * @program: practice
 * @description: 填充每个节点的下一个右侧节点指针
 * @author: Jiaty
 * @create: 2020-10-15 10:18
 **/

public class Solution116 {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    /**
     * @param root
     * @return
     */
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    public void dfs(Node root) {
        if (root == null || root.left == null) {
            return;
        }
        //先将左边的子节点的next指定，然后如果没有并列一排的，那就继续深入到下一层
        root.left.next = root.right;
        if (root.next != null) {
            //如果是有并列一排的，那就可以将右边的子节点的next直接指定
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }




    public Node connet(Node root){
        if (root == null){
            return null;
        }
        while(root.left != null){


            root.left.next = root.right;
            if (root.next != null){
                root.right.next = root.next.left;
            }
            root = root.left;
        }
        return root;
    }


}
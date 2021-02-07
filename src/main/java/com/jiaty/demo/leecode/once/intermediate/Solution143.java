package com.jiaty.demo.leecode.once.intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description: 重排链表
 * @author: Jiaty
 * @create: 2020-10-20 10:35
 **/

public class Solution143 {
    /**
     * 栈溢出的递归写法。。。。
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        if (head.next.next.next == null) {
            ListNode node = head.next;
            head.next = head.next.next;
            head.next.next = node;
        }
        reorderList(head.next);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            String s = next == null ? "null" : next.toString();
            return val + "->" + s;
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

//        System.out.println(node.toString());
        reorderList(node);
        System.out.println(node);
    }


    /**
     * 线性表
     * <p>
     * <p>
     * 因为链表不支持下标访问，所以我们无法随机访问链表中任意位置的元素
     * 因此想到的某个办法就是，我们利用线性表存储该链表，通过线性表可以访问下标的特点，直接按顺序访问指定元素，重建该链表即可
     */

    public static void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 寻找链表中点 + 链表逆序 + 合并链表
     * <p>
     * 注意到目标链表即为将原链表的左半端和反转后的右半端合并后的结果
     * <p>
     * 这样的我们的任务可以划分为散步
     * 1。找到愿链表的中点
     * 可以使用快慢指针找到链表的中间节点（@ToSee  Solution876）
     * <p>
     * 2。将原链表的右半端反转
     * 可以使用迭代法实现链表的反转 (@ToSee 反转链表)
     * 3。将原链表的两端合并
     * 因为两链表长度相差不超过1，因此直接合并即可
     */
    public static void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    /**
     * 寻找链表的中点
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }


    }

}
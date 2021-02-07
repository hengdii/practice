package com.jiaty.demo.leecode.once.intermediate;

/**
 * @author Jiaty
 * @date 2020/10/10 23:16
 */
public class Solution142 {


    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return val + "->" + next == null?"null":next.toString();
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }


//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(3);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(0);
//        listNode.next.next.next = new ListNode(-4);
//        listNode.next.next.next.next = listNode.next;
//        System.out.printf(detectCycle(listNode).toString());
//
//    }




}

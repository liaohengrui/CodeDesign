package com.example.linked_list;

import sun.applet.Main;

import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/20
 */
public class OddEvenNode {
    ListNode oddPoint;
    ListNode evenPoint;
    ListNode firstEvenNode;

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        oddPoint = head;
        evenPoint = head.next;
        firstEvenNode = head.next;
        if (evenPoint.next == null) {
            return head;
        }
        while (evenPoint.next != null) {
            oddPoint.next = evenPoint.next;
            oddPoint = oddPoint.next;
            if (oddPoint.next != null) {
                evenPoint.next = oddPoint.next;
                evenPoint = evenPoint.next;
            } else {
                evenPoint.next=null;
            }
        }
        oddPoint.next = firstEvenNode;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = null;
     /*   listNode3.next = listNode4;
        listNode4.next = listNode5;*/
        OddEvenNode main = new OddEvenNode();
        main.oddEvenList(listNode1);
    }

}

package com.example.linked_list;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/17
 */
public class CycleLinkedList {
    ListNode fastPoint;
    ListNode slowPoint;

    public ListNode detectCycle(ListNode head) {
        fastPoint = getMeetPoint(head);
        if (fastPoint == null) {
            return null;
        }
    
        slowPoint = head;
        while (!(fastPoint == slowPoint)) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }
        return fastPoint;
    }

    private ListNode getMeetPoint(ListNode head) {
        if (head == null || head.next == null|| head.next.next == null) {
            return null;
        }
        slowPoint = head.next;
        fastPoint = head.next.next;
        while (!(fastPoint == slowPoint)) {
            try {
                fastPoint = fastPoint.next.next;
            } catch (Exception e) {
                return null;
            }
            slowPoint = slowPoint.next;

        }
        return fastPoint;
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
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(cycleLinkedList.detectCycle(listNode));
    }
}

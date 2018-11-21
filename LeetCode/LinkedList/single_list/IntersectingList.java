package com.example.linked_list;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/18
 */

@SuppressWarnings("ALL")
public class IntersectingList {
    ListNode fastPoint;
    ListNode slowPoint;
    ListNode changePoint;

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        createCycle(headA);
        fastPoint = getMeetPoint(headB);
        slowPoint = headB;
        while (!(fastPoint == slowPoint)) {
            try {
                fastPoint = fastPoint.next;
            } catch (Exception e) {
                changePoint.next=null;
                return null;
            }
            slowPoint = slowPoint.next;
        }
        changePoint.next=null;
        return fastPoint;
    }


    private ListNode getMeetPoint(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
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

    private void createCycle(ListNode node) {
        ListNode head = node;
        while (!(node.next == null)) {
            node = node.next;
        }
        changePoint=node;
        node.next = head;
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
}

package com.example.linked_list;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/21
 * @question 金山办公软件C++开发工程师笔试题（3）
 */
public class DFXTest {
    Stack<ListNode> nodeStack = new Stack<>();
    Set set = new HashSet();

    void deleteUniqueNode(ListNode head) {
        ListNode temp = head;
        while (head != null) {
            nodeStack.push(head);
            if (!set.add(head.val)) {
                set.remove (head.val);
            }
            head = head.next;
        }
        while (!nodeStack.isEmpty()) {
            ListNode listNode = nodeStack.pop();
            if (set.contains(listNode.val)) {
                try {
                    //可能出现删除第一个元素
                    ListNode listNode2 = nodeStack.peek();
                    listNode2.next = listNode2.next.next;
                } catch (Exception e) {
                    temp=listNode.next;
                }

            }
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(7);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        DFXTest dfxTest = new DFXTest();
        dfxTest.deleteUniqueNode(listNode1);
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

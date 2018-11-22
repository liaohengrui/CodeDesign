package com.example.double_linked_list;

import java.util.LinkedList;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/22
 */
public class DesignLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DesignLinkedList() {
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        //没有头结点
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node newHead = new Node(val);
            head.prev = newHead;
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        //如果没有tail
        if (tail == null) {
            addAtHead(val);
        } else {
            Node newTail = new Node(val);
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if ( index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node node = getIndex(index);
        Node prevNode = node.prev;
        Node newNode = new Node(val);
        newNode.prev = prevNode;
        newNode.next = node;
        prevNode.next = newNode;
        node.prev = newNode;
        size++;
        return;
    }

    private Node getIndex(int index) {
        Node node = head;
        if (node == null || index >= size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int get(int index) {
        try {
            return getIndex(index).val;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node node = getIndex(index);
        if (node == null) {
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        if (index == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private class Node {
        int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }
}

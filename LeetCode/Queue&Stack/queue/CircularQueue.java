package com.example.demo;

import org.springframework.util.Assert;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/2
 */
public class CircularQueue {
    int[] ints;
    int head, tail;
    int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public CircularQueue(int k) {
        ints = new int[k];
        tail = -1;
        head = 0;
        size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            nextTail();
            ints[tail] = value;
            size++;
            return true;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            nextHead();
            size--;
            return true;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return ints[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return ints[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == ints.length;
    }

    public void nextTail() {
        tail++;
        if (tail == ints.length) {
            tail = 0;
        }
    }

    public void nextHead() {
        head++;
        if (head == ints.length) {
            head = 0;
        }
    }
}

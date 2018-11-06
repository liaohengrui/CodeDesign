package com.example.demo;

import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/5
 */
public class MinStack {
    Stack stack;
    int min;
    int time;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
    }

    public void push(int x) {
        if (time == 0) {
            min = x;
            time++;
        }
        stack.push(x);
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int compare = (int) stack.pop();
            if (min == compare) {
                if (!stack.isEmpty()) {
                    min = (int) stack.peek();
                    for (int i = 0; i < stack.size(); i++) {
                        if (min > (int) stack.get(i)) {
                            min = (int) stack.get(i);
                        }
                    }
                } else {
                    time = 0;
                }
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return (int) stack.peek();
        }
        return -1;

    }

    public int getMin() {
        return min;
    }



}

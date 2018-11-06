package com.example.demo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/6
 */
public class DailyTemperatures {
    Stack<Integer> stack = new Stack<>();
    int size;
    int[] result;

    public int[] dailyTemperatures(int[] temperatures) {
        size = temperatures.length;
        result = new int[size];
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int t = stack.peek();
                stack.pop();
                result[t] = i - t;
            }
            stack.push(i);

        }
        return result;
    }



}

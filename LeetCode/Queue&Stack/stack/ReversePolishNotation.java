package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/6
 */
public class ReversePolishNotation {
    private Stack<String> stack = new Stack<>();
    List<String> list = new ArrayList();

    public ReversePolishNotation() {
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
    }

    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (!checkSymbol(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                int y = Integer.valueOf(stack.pop());
                int x = Integer.valueOf(stack.pop());
                String operate = tokens[i];
                int operateNum = operationNum(x, y, operate);
                stack.push(String.valueOf(operateNum));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private int operationNum(int x, int y, String operate) {
        if (operate.equals("+")) {
            return x + y;
        }
        if (operate.equals("-")) {
            return x - y;
        }
        if (operate.equals("*")) {
            return x * y;
        }
        if (operate.equals("/")) {
            return x / y;
        }
        return 0;
    }

    private boolean checkSymbol(String token) {

        return list.contains(token);
    }


}

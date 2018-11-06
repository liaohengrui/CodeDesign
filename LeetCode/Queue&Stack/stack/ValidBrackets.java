package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/5
 */
public class ValidBrackets {
    private Stack originStack = new Stack();


    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        try {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (!judgeCharLeft(s.charAt(i))) {
                    originStack.push(s.charAt(i));
                } else {
                    if (!judgeCharLegal(s.charAt(i), (Character) originStack.pop())) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean judgeCharLegal(char c, char auxiliaryC) {
        if (c == '(' && auxiliaryC == ')' || c == '{' && auxiliaryC == '}' || c == '[' && auxiliaryC == ']') {
            return true;
        }
        return false;
    }

    private boolean judgeCharLeft(char c) {
        if (c == '(' || c == '{' || c == '[') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidBrackets validBrackets = new ValidBrackets();
        System.out.println(validBrackets.isValid("()[]{}"));
    }


}

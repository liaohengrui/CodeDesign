package com.example.string;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/15
 */
public class ReverseStr {
    int head, tail;
    char[] chars;

    public String reverseString(String s) {
        if (s.length() == 1) {
            return s;
        }
        chars = new char[s.length()];
        head = 0;
        tail = s.length() - 1;
        while (!(tail - head < 1) || tail - head == 0) {
            chars[head] = s.charAt(tail);
            chars[tail] = s.charAt(head);
            tail--;
            head++;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseString("hello"));
    }
}

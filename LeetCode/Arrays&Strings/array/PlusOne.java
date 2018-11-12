package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/12
 */
public class PlusOne {


    public int[] plusOne(int[] digits) {
        int temp = 0;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i];
            num += temp;
            if (num >= 10) {
                digits[i] = num % 10;
                temp = num / 10;
            } else {
                digits[i] = num;
                temp = 0;
            }
        }
        if (temp != 0) {

            int[] ints = new int[digits.length + 1];
            System.arraycopy(digits, 0, ints, 1, digits.length);
            ints[0] = temp;
            return ints;
        }

        return digits;
    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{9});
        System.out.println("---");
    }


}

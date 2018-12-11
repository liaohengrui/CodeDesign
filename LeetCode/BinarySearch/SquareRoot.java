package com.example.BinarySearch;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/29
 */
public class SquareRoot {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long middle = 0;
        while (right - left >= 0) {
            middle = left + (right - left) / 2;
            long result = middle * middle;
            if (result == x || (result < x && (middle + 1) * (middle + 1) > x)) {
                return (int) middle;
            }
            if (result > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SquareRoot().mySqrt(2147395599));
    }
}

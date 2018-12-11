package com.example.BinarySearch;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/29
 */
public class GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int middle = 0;
        while (right - left >= 0) {
            middle = left + (right - left) / 2;
            if (guess(middle) == 0) {
                return middle;

            }
            if (guess(middle) == 1) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public int guess(int num) {
        if (num == 6) {
            return 0;
        }
        if (num > 6) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GuessGame().guessNumber(10));
    }
}

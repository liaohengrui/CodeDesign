package com.example.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/23
 */
public class HappyNums {
    Set set = new HashSet();
    int result = 0;

    public boolean isHappy(int n) {
        boolean flag = true;
        result = n;
        while (flag) {
            flag = squareNum(result);
        }
        return result == 1;
    }

    private boolean squareNum(int n) {
        String s = String.valueOf(n);
        result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += (s.charAt(i) - 48) * (s.charAt(i) - 48);
        }
        if (result == 1) {
            //无意义,结束循环
            return false;
        } else {
            return set.add(result);
        }
    }

    public static void main(String[] args) {
        HappyNums happyNums = new HappyNums();
        System.out.println(happyNums.isHappy(19));
    }
}

package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/12
 */
public class AnywayDouble {
    public int dominantIndex(int[] nums) {
        List<Integer> dynamicArray = new ArrayList<>();
        for (int i : nums) {
            dynamicArray.add(i);
        }
        int maxNum = Collections.max(dynamicArray);
        for (Integer integer : dynamicArray) {
            if (integer == maxNum) {
                continue;
            } else {
                if (integer * 2 > maxNum) {
                    return -1;
                }
            }
        }
        return dynamicArray.indexOf(maxNum);
    }

    public static void main(String[] args) {
        new AnywayDouble().dominantIndex(new int[]{0, 0, 0, 1});
    }
}

package com.example.string;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/15
 */
public class ArraySplit1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int sum = 0;
        while (j < nums.length) {
            sum += Math.min(nums[i], nums[j]);
            i += 2;
            j += 2;
        }
        return sum;
    }


}

package com.example.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/23
 */
public class SingleNum {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        for (int i : nums) {
            result = i ^ result;
        }
        return result;
    }
}

package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/23
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value) && (int) map.get(value) != i) {
                ints[0] = i;
                ints[1] = (int) map.get(value);
                return ints;
            }
        }
        return null;
    }
}

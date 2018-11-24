package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/24
 */
public class DuplicateArray {
    Map<Integer, Integer> map = new HashMap<>();

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int result = map.get(nums[i]);
                if (i - result == k) {
                    return true;
                } else if (i - result > k) {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateArray duplicateArray = new DuplicateArray();
        duplicateArray.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
    }
}

package com.example.binary_search_tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/17
 */
public class DuplicateNums {
    public static void main(String[] args) {
        DuplicateNums duplicateNums = new DuplicateNums();
        System.out.println(duplicateNums.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        ;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && (Long.valueOf(ceiling) - Long.valueOf(nums[i])) <= t) {
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if (floor != null && (Long.valueOf(nums[i]) - Long.valueOf(floor)) <= t) {
                return true;
            }
            set.add(nums[i]);
            if (i - k >= 0) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

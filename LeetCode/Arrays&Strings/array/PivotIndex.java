package com.example.array;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/12
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int right = total - left - nums[i];
            if (right == left) {
                return i;
            } else {
                left+=nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

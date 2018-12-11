package com.example.BinarySearch;

import java.util.Collections;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/29
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length < 3) {
            if (nums.length == 1) {
                return 0;
            } else {
                return nums[0] > nums[1] ? 0 : 1;
            }
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while (left + 1 < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] < nums[middle + 1]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return nums[right] > nums[left] ? right : left;
    }

    public static void main(String[] args) {
        System.out.println(new PeakElement().findPeakElement(new int[]{1, 2, 3, 1}));
    }
}

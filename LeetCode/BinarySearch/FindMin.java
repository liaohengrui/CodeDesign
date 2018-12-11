package com.example.BinarySearch;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12
 */
public class FindMin {

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{1, 2}));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[0];
    }

}

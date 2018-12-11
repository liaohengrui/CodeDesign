package com.example.BinarySearch.template3;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/10
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(new SearchRange().searchRange(new int[]{1, 1, 2}, 1));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        int end = -1;
        if (nums == null || nums.length == 0) {
            return new int[]{start, end};
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                end = mid;
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{start, end};
    }
}

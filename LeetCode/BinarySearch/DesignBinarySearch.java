package com.example.BinarySearch;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/26
 */
public class DesignBinarySearch {
    int left, middle, right;

    public int search(int[] nums, int target) {
        left = 0;
        right = nums.length - 1;
        middle = (left + right) / 2;
        while (!(nums[middle] == target)) {
            if (nums[middle] > target) {
                right = middle;
                middle = (left + right) / 2;
            } else {
                left = middle + 1;
                middle = (left + right) / 2;
            }
            if (right - left == 1||right==left) {
                if (nums[left] != target && nums[right] != target) {
                    return -1;
                }
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-1, 0, 5};
        System.out.println(new DesignBinarySearch().search(ints, -1));
    }
}

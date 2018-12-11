package com.example.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/29
 */
public class SearchRotateArrays {
    public int search(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }

        int n = sortNums(nums);
        int k = nums.length - n;
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while (right - left >= 0) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                if (middle < n) {
                    return middle + k;
                } else {
                    return middle - n;
                }
            }
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    private int sortNums(int[] ints) {
        int result = 0;
        while (!(result == ints.length - 1)) {
            if (!(ints[result] < ints[result + 1])) {
                //翻转了N个数
                Arrays.sort(ints);
                return ints.length - result - 1;
            }
            result++;
        }
        Arrays.sort(ints);
        return 0;
    }



}

package com.example.string;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/15
 */
public class MinSubarray {
    public int minSubArrayLen(int s, int[] nums) {
        int point1 = 0;
        int point2 = -1;
        int sum = 100000;
        int addNum = 0;
        if (nums.length == 0) {
            return 0;
        }
        while ((point1 < nums.length)) {
            if (addNum < s) {
                if (point2 < nums.length - 1) {
                    point2++;
                    addNum += nums[point2];
                } else {
                    point1++;
                }
            } else {
                if (sum > point2 - point1) {
                    sum = point2 - point1;
                }
                if (point1 < nums.length) {
                    addNum -= nums[point1];
                    point1++;
                }
            }

        }

        return sum == 100000 ? 0 : sum + 1;
    }

    public static void main(String[] args) {
        MinSubarray subarray = new MinSubarray();
        System.out.println(subarray.minSubArrayLen(5, new int[]{5}));
    }

}

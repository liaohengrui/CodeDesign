package com.example.string;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/15
 */
public class ArraySplit2 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int result[] = new int[2];
        while (start < end) {
            int temp = numbers[start] + numbers[end];
            if (temp == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if (temp < target) {
                start++;
            } else if (temp > target) {
                end--;
            }
        }
        return result;
    }
}

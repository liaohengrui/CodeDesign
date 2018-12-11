package com.example.BinarySearch;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/29
 */
public class VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int middle = 0;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (!isBadVersion(middle)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private boolean isBadVersion(int middle) {
        return false;
    }
}

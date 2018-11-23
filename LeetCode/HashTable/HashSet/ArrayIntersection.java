package com.example.hash;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/23
 */
public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet();
        Set set1 = new HashSet();
        if (nums1.length>nums2.length){
            for (int i : nums1) {
                set.add(i);
            }
            for (int i : nums2) {
                if (set.contains(i)) {
                    set1.add(i);
                }
            }
        }else {
            for (int i : nums2) {
                set.add(i);
            }
            for (int i : nums1) {
                if (set.contains(i)) {
                    set1.add(i);
                }
            }
        }

        int[] ints = new int[set1.size()];
        Iterator iterator = set1.iterator();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) iterator.next();
        }
        return ints;
    }
}
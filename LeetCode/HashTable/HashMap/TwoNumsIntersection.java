package com.example.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/24
 */
public class TwoNumsIntersection {
    Map<Integer, Integer> map = new HashMap();

    public int[] intersect(int[] nums1, int[] nums2) {
        for (int i : nums1) {
            if (map.containsKey(i)) {
                int result = map.get(i) + 1;
                map.put(i, result);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                if (map.get(i) - 1 == 0) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i) - 1);
                }
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}



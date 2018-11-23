package com.example.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/23
 */
public class DuplicateElement {
    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}

package com.example.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/24
 */
public class FirstOnlyOneChar {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int result = map.get(c) + 1;
                map.put(c, result);
            } else {
                map.put(c, 1);
            }
        }
        if (map.containsValue(1)) {
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i))==1){
                    return i;
                }
            }
        }
        return -1;
    }
}

package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/23
 */
public class IsomorphicStr {
    public boolean isIsomorphic(String s, String t) {
        Map map = new HashMap();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (!map.containsKey(chars1[i])) {
                if (map.containsValue(chars2[i])){
                    return false;
                }
                map.put(chars1[i], chars2[i]);
            } else {
                char c = (char) map.get(chars1[i]);
                if (c != chars2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStr isomorphicStr = new IsomorphicStr();
        System.out.println(isomorphicStr.isIsomorphic("ab", "aa"));
    }
}

package com.example.DesignKey;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/24
 */
public class LetterEctopicGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String i = customizeKey(s);
            if (map.containsKey(i)) {
                List list = map.get(i);
                list.add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(i, list);
            }
        }
        List<List<String>> list = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    private String customizeKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }



}

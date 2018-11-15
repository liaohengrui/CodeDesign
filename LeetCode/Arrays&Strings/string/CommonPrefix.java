package com.example.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/15
 */
public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (strs.length == 0) {
            return "";
        }
        int strLength = strs[0].length();

        StringBuffer buffer = new StringBuffer();
        try {
            for (int i = 0; i < strLength; i++) {
                for (int j = 1; j < length; j++) {
                    if (strs[0].charAt(i) != strs[j].charAt(i)) {
                        return buffer.toString();
                    }
                }
                buffer.append(strs[0].charAt(i));
            }
        } catch (Exception e) {
            return buffer.toString();
        }
        return buffer.toString();
    }


}

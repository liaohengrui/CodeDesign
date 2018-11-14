package com.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/14
 */
public class YanghuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (i != 0) {
                list.add(1);
            }
            for (int j = 1; j < i; j++) {
                int num = lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j);
                list.add(j, num);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        YanghuiTriangle triangle = new YanghuiTriangle();
        triangle.generate(5);
    }
}

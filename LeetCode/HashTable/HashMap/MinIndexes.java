package com.example.hashmap;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/23
 */
public class MinIndexes {
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, List> result = new HashMap<>();
    int resultStep = 10000;

    public String[] findRestaurant(String[] list1, String[] list2) {
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int n = i + map.get(list2[i]);
                if (resultStep > n) {
                    result.remove(resultStep);
                    resultStep = n;
                    List<String> list = new ArrayList<>();
                    list.add(list2[i]);
                    result.put(resultStep, list);
                } else if (resultStep == n) {
                    List<String> list = result.get(resultStep);
                    list.add(list2[i]);
                    result.put(resultStep, list);
                }
            }
        }
        String[] strings = new String[result.get(resultStep).size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = (String) result.get(resultStep).get(i);
        }

        return strings;
    }

    public static void main(String[] args) {
        MinIndexes indexes = new MinIndexes();
        String[] strings = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] strings2 = new String[]{"KFC", "Shogun", "Burger King"};

        System.out.println(indexes.findRestaurant(strings, strings2));
        ;
    }

}

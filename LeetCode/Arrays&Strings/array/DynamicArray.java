package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/12
 */
public class DynamicArray {
    public static void main(String[] args) {
        List<Integer> dynamicArray;
        Integer[] integers = new Integer[]{1, 0, 2, 3, 4, 5};
        dynamicArray = new ArrayList<>(Arrays.asList(integers));
        for (Integer integer : dynamicArray) {
            System.out.print(integer);
        }
        System.out.println();
        Collections.sort(dynamicArray);
        for (Integer integer : dynamicArray) {
            System.out.print(integer);
        }
        System.out.println();
        dynamicArray.add(0,new Integer(20));
        for (Integer integer : dynamicArray) {
            System.out.print(integer);
        }

    }
}

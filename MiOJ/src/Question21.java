import sun.print.PSPrinterJob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/1
 */
public class Question21 {
    static List<Integer> integers = new ArrayList<>();
    static int SIGNAL = -1000;


    private static String solution(String line) {
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        String[] strings = line.split(" ");
        String[] temp = strings[0].split(",");
        for (int i = 0; i < temp.length; i++) {
            num1.add(Integer.valueOf(temp[i]));
        }
        temp = strings[1].split(",");
        for (int i = 0; i < temp.length; i++) {
            num2.add(Integer.valueOf(temp[i]));
        }
        solution(num1, num2, Integer.valueOf(strings[2]));
        StringBuffer buffer = new StringBuffer();
        for (int i : integers) {
            buffer.append(i);
        }
        return buffer.toString();
    }

    private static void solution(List<Integer> num1, List<Integer> num2, int remaining) {
        for (int i = remaining; i > 0; i--) {
            findSpecialMax(num1, num2, i);
        }
    }


    private static void findSpecialMax(List<Integer> num1, List<Integer> num2, int remaining) {
        int max1 = -1000;
        if (!num1.isEmpty()) {
            max1 = Collections.max(num1);
        }
        int max2 = -1000;
        if (!num2.isEmpty()) {
            max2 = Collections.max(num2);
        }

        if (max1 == max2) {
            int indexMax1 = num1.indexOf(max1);
            int indexMax2 = num2.indexOf(max2);
            if (num1.size() - indexMax1 > num2.size() - indexMax2) {
                integers.add(max1);
                for (int i = 0; i <= indexMax1; i++) {
                    num1.remove(0);
                }
            } else {
                integers.add(max2);
                for (int i = 0; i <= indexMax2; i++) {
                    num2.remove(0);
                }
            }
            return;

        }

        if (max1 > max2) {
            int indexMax1 = num1.indexOf(max1);
            if (num2.size() + (num1.size() - indexMax1) >= remaining) {
                integers.add(max1);
                for (int i = 0; i <= indexMax1; i++) {
                    num1.remove(0);
                }
            } else {
                num1.set(indexMax1, SIGNAL);
                SIGNAL--;
                findSpecialMax(num1, num2, remaining);
                SIGNAL++;
                num1.set(num1.indexOf(SIGNAL), max1);
            }
        } else {
            int indexMax2 = num2.indexOf(max2);
            if (num1.size() + (num2.size() - indexMax2) >= remaining) {
                integers.add(max2);
                for (int i = 0; i <= indexMax2; i++) {
                    num2.remove(0);
                }
            } else {
                num2.set(indexMax2, SIGNAL);
                SIGNAL--;
                findSpecialMax(num1, num2, remaining);
                SIGNAL++;
                num2.set(num2.indexOf(SIGNAL), max2);

            }
        }
    }
}

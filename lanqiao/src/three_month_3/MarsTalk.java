package three_month_3;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/9
 */
@SuppressWarnings("ALL")
public class MarsTalk {
    static int times;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        times = scanner.nextInt();
        int n = scanner.nextInt();
        int[] ints = new int[times];
        for (int i = 0; i < times; i++) {
            ints[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            addOne(ints);
        }
        for (int i : ints) {
            System.out.print(i + " ");
        }

    }

    private static int[] addOne(int[] ints) {
        int len = ints.length;
        int index = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (ints[i] < ints[i + 1]) {
                index = i;
                break;
            }
        }


        int exchangeIndex = len - 1;
        for (int i = index + 1; i < len; i++) {
            if (ints[i] < ints[index]) {
                exchangeIndex = i - 1;
                break;
            }
        }

        int temp = ints[index];
        ints[index] = ints[exchangeIndex];
        ints[exchangeIndex] = temp;


        int[] intt = new int[len - index - 1];
        for (int i = 0; i < intt.length; i++) {
            intt[i] = ints[index + 1 + i];
        }
        Arrays.sort(intt);
        for (int i = index + 1; i < len; i++) {
            ints[i] = intt[i - index - 1];
        }
        return ints;
    }

}

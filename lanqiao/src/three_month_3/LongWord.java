package three_month_3;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/9
 */
public class LongWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println(getLongWord(word));
    }

    private static String getLongWord(String word) {
        String[] words = word.split(" ");
        String i = "";
        for (String s : words) {
            if (s.length() > i.length()) {
                i = s;
            }
        }
        return i;
    }
}

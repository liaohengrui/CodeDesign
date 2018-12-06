package previous_question;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/5
 */
public class MinCalculator {
    public static void main(String[] args) {
        long result = 0;
        int radix = 10;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            if (s.contains("CLEAR")) {
                i++;
                s = scanner.nextLine();
                result = Long.valueOf(s.split(" ")[1]);
                continue;
            }
            if (s.contains("CHANGE")) {
                radix = Integer.parseInt(s.split(" ")[1]);
                continue;
            }
            if (s.contains("ADD")) {
                i++;
                s = scanner.nextLine();
                String num = s.split(" ")[1];
                result += Long.valueOf(num, radix);
                continue;
            }
            if (s.contains("SUB")) {
                i++;
                s = scanner.nextLine();
                String num = s.split(" ")[1];
                result -= Long.valueOf(num, radix);
                continue;
            }
            if (s.contains("MUL")) {
                i++;
                s = scanner.nextLine();
                String num = s.split(" ")[1];
                result *= Long.valueOf(num, radix);
                continue;
            }
            if (s.contains("DIV")) {
                i++;
                s = scanner.nextLine();
                String num = s.split(" ")[1];
                result /= Long.valueOf(num, radix);
                continue;
            }
            if (s.contains("MOD")) {
                i++;
                s = scanner.nextLine();
                String num = s.split(" ")[1];
                result %= Long.valueOf(num, radix);
                continue;
            }
            if (s.contains("EQUAL")) {
                System.out.println(toN(result, radix));
                continue;
            }
        }
    }

    private static String toN(long i, int radix) {
        StringBuffer buffer = new StringBuffer();
        while (!(i == 0)) {
            long k = i % radix;
            if (k < 10) {
                buffer.insert(0, k);
            } else {
                char c = (char) (k + 55);
                buffer.insert(0, c);
            }
            i = i / radix;
        }
        return buffer.toString();
    }
}
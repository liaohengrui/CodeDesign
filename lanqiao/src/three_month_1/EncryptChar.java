package three_month_1;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class EncryptChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            buffer.append(encryptChar(String.valueOf(s.charAt(i))));
        }

        System.out.println(buffer.toString());
    }

    private static String encryptChar(String s) {
        if (s.equals("z")) {
            return "A";
        }
        if (s.equals("Z")) {
            return "a";
        }
        if ("A".hashCode() <= s.hashCode() && s.hashCode() < "Z".hashCode()) {
            return Character.toString((char) (s.hashCode() + 1));
        }
        if ("a".hashCode() <= s.hashCode() && s.hashCode() < "z".hashCode()) {
            return Character.toString((char) (s.hashCode() + 1));
        }
        return s;
    }
}

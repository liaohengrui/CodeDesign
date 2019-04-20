package three_month_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class Factorization {
    static List<Integer> buffer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        factorization(n);
        StringBuffer bufferS = new StringBuffer();
        for (int i = 0; i < buffer.size(); i++) {
            bufferS.append(buffer.get(i));
            bufferS.append("*");
        }
        bufferS.deleteCharAt(bufferS.length() - 1);
        System.out.println(bufferS.toString());
    }

    private static void factorization(int num) {
        if (num == 1) {
            return;
        }
        if (num % 2 == 0) {
            buffer.add(2);
            factorization(num / 2);
        } else {
            for (int i = 3; i <= num; i += 2) {
                if (num % i == 0) {
                    buffer.add(i);
                    factorization(num / i);
                    break;
                }
            }
        }
    }
}

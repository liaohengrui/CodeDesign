package three_month_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/3
 */
public class JumpStair {
    static Set<Integer> traps;
    static int end;
    static int counter;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int m = scanner.nextInt();
        traps = new HashSet<>();
        end = len;
        for (int i = 0; i < m; i++) {
            traps.add(scanner.nextInt());
        }
        jump(1);
        System.out.println(counter);
    }

    private static void jump(int index) {
        if (index == end) {
            counter++;
            return;
        }
        if (traps.contains(index) || index > end) {
            return;
        }
        jump(index + 1);
        jump(index + 2);
    }
}

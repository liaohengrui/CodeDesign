package three_month_1;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class BallVolume {
    public final static double PI = 3.1415926;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        String s = String.valueOf(4 * PI * r * r * r / 3);
        String shiwei = s.split("\\.")[0];
        String fenshu = s.split("\\.")[1];
        fenshu = fenshu.substring(0, 6);
        char c = fenshu.charAt(5);
        int fenshuNum = Integer.valueOf(fenshu.substring(0, 5));
        if (c >= '5') {
            fenshuNum++;
        }
        s = shiwei + "." + String.valueOf(fenshuNum);
        System.out.println(s);

    }
}

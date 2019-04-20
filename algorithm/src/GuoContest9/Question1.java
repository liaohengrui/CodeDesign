package GuoContest9;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/17
 */
public class Question1 {
    static int min = 100;

    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            int remain = 200 - (5 * i);
            if (remain % 21 == 0) {
                int x = remain / 21;
                if (x > 0) {
                    min = min > i + x * 11 ? i + x * 11 : min;
                }
            }
        }
        System.out.println(min);
    }
}

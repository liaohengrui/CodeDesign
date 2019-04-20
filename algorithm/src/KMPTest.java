import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/16
 */
public class KMPTest {

    public static void main(String[] args) {
        String[] A = "ab".split("");
        String[] B = "ababababab".split("");
        F = createF(A);
        kmpFind(A, B);
    }

    static int[] F;

    private static void kmpFind(String[] A, String[] B) {
        //A是带匹配的
        int i = 0;
        int j = 0;
        while (j < B.length) {
            if (A[i].equals(B[j])) {
                i++;
                j++;
                if (i == A.length) {
                    System.out.println("匹配成功  起始位置 : " + (j - A.length + 1));
                    i = F[i - 1] + 1;
                }
            } else {
                if (j == 0) {
                    j++;
                } else {
                    i = F[i - 1] + 1;
                }
            }
        }
    }


    private static int[] createF(String[] ints) {
        int[] f = new int[ints.length];
        f[0] = -1;
        for (int i = 1; i < ints.length; i++) {
            int j = f[i - 1];
            while (!ints[j + 1].equals(ints[i]) && j >= 0) {
                j = f[j];
            }
            if (ints[j + 1].equals(ints[i])) {
                f[i] = j + 1;
            } else {
                f[i] = -1;
            }
        }
        return f;
    }
}

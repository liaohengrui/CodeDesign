import java.security.Signature;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/27
 */
public class Question16 {
    public static void main(String[] args) {
        System.out.println(solution("346 - 0 / 16 * 12"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        Integer[] nums = new Integer[(strings.length + 1) / 2];
        String[] signs = new String[strings.length / 2];
        int j = 0;
        for (int i = 0; i < strings.length; i++) {
            nums[j] = Integer.valueOf(strings[i]);
            if (i != strings.length - 1) {
                signs[j] = String.valueOf(strings[++i]);
            }
            j++;
        }
        return solution(nums, signs);
    }

    private static String solution(Integer[] nums, String[] signs) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> signStack = new Stack<>();
        integerStack.push(nums[0]);
        integerStack.push(nums[1]);
        signStack.push(signs[0]);
        for (int i = 2; i < nums.length; i++) {
            Integer num = nums[i];
            String sign = signs[i - 1];
            if (signStack.isEmpty() || canAdd(signStack.peek(), sign)) {
                integerStack.push(num);
                signStack.push(sign);
            } else {
                while (!signStack.isEmpty() && !canAdd(signStack.peek(), sign)) {
                    int i1 = integerStack.pop();
                    int i2 = integerStack.pop();
                    String sign1 = signStack.pop();
                    try {
                        integerStack.push(calculate(i1, i2, sign1));
                    } catch (Exception e) {
                        return "err";
                    }

                }
                integerStack.push(num);
                signStack.push(sign);

            }
        }
        int result = 0;
        while (!signStack.isEmpty()) {
            int i1 = integerStack.pop();
            int i2 = integerStack.pop();
            String sign1 = signStack.pop();
            try {
                result = calculate(i1, i2, sign1);
            } catch (Exception e) {
                return "err";
            }

            integerStack.push(result);
        }

        return String.valueOf(result);
    }

    private static int calculate(int i1, int i2, String sign) {
        if (sign.equals("+")) {
            return i2 + i1;
        }
        if (sign.equals("-")) {
            return i2 - i1;
        }
        if (sign.equals("*")) {
            return i2 * i1;
        }
        if (sign.equals("/")) {
            return i2 / i1;
        }
        return 0;
    }

    private static boolean canAdd(String s1, String s2) {
        if ((s2.equals("*") || s2.equals("/")) && (s1.equals("+") || s1.equals("-"))) {
            return true;
        }
        return false;
    }
}

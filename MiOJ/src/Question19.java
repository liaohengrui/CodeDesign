/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/1
 */
public class Question19 {


    private static String solution(String line) {
        if (line.contains(">")) {
            String[] strings = line.split(">");
            boolean b = judgeSize(new StringBuffer(strings[0]), new StringBuffer(strings[1]));
            return b ? "Y" : "N";
        }
        if (line.contains("<")) {
            String[] strings = line.split("<");
            boolean b = judgeSize(new StringBuffer(strings[1]), new StringBuffer(strings[0]));
            return b ? "Y" : "N";
        }
        String[] strings = line.split("[+]");
        return bigNumberPlus(strings[0], strings[1]);
    }

    private static boolean judgeSize(StringBuffer buffer1, StringBuffer buffer2) {
        if (buffer1.length() > buffer2.length()) {
            return true;
        } else if (buffer1.length() == buffer2.length()) {
            for (int i = 0; i < buffer1.length(); i++) {
                if (buffer1.charAt(i) > buffer2.charAt(i)) {
                    return true;
                }
                if (buffer1.charAt(i) < buffer2.charAt(i)) {
                    return false;
                }
            }
        }
        return false;
    }

    private static String bigNumberPlus(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        } else if (num2.length() == 0) {
            return num1;
        }

        //设置一个进位标志
        boolean plus1 = false;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int p1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int p2 = j >= 0 ? num2.charAt(j--) - '0' : 0;

            int sum = p1 + p2 + (plus1 ? 1 : 0);

            if (sum >= 10) {
                builder.insert(0, Integer.toString(sum - 10));
                plus1 = true;
            } else {
                builder.insert(0, Integer.toString(sum));
                plus1 = false;
            }
            //i--;
            //j--;

        }

        if (plus1) {
            builder.insert(0, "1");
        }
        return builder.toString();

    }

}

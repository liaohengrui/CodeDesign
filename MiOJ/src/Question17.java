import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/27
 */
public class Question17 {
    static int position = 0;
    static boolean canAddZero = true;
    static boolean million = true;
    static boolean billion = true;
    static StringBuffer buffer = new StringBuffer();



    private static String solution(String line) {
        List<Integer> list = new ArrayList<>();
        for (int i = line.length() - 1; i >= 0; i--) {
            list.add(Integer.valueOf(line.charAt(i) - 48));
        }

        return solution(list);
    }

    private static String solution(List<Integer> num) {
        for (int i = 0; i < num.size(); i++) {
            position = i;
            if (num.get(i) == 0) {
                if (canAddZero) {
                    buffer.insert(0, numsToWord(num.get(i)));
                    canAddZero = false;
                }
            } else {
                buffer.insert(0, unit(position));
                buffer.insert(0, numsToWord(num.get(i)));
                canAddZero = true;
            }
        }
        buffer.append("元整");

        while (buffer.length() - 3 >= 0 && buffer.charAt(buffer.length() - 3) == '零') {
            buffer.deleteCharAt(buffer.length() - 3);
        }
        while (buffer.charAt(0) == '零') {
            buffer.deleteCharAt(0);
        }
        if (buffer.length() == 2) {
            buffer.insert(0, "零");
        }
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == '零') {
                if (i + 2 >= 0 && buffer.charAt(i + 2) == '仟') {
                    buffer.deleteCharAt(i);
                    i--;
                }
            }
        }

        return buffer.toString();
    }

    private static String unit(int position) {
        if (position > 3 && position < 8) {
            position -= 4;
            if (million) {
                million = false;
                if (position == 0) {
                    return "万";
                }
                if (position == 1) {
                    return "拾万";
                }
                if (position == 2) {
                    return "佰万";
                }
                if (position == 3) {
                    return "仟万";
                }
            }
        }
        if (position > 7) {
            position -= 8;
            if (billion) {
                billion = false;
                if (position == 0) {
                    return "亿";
                }
                if (position == 1) {
                    return "拾亿";
                }
                if (position == 2) {
                    return "佰亿";
                }
                if (position == 3) {
                    return "仟亿";
                }
            }
        }
        if (position == 1) {
            return "拾";
        }
        if (position == 2) {
            return "佰";
        }
        if (position == 3) {
            return "仟";
        }

        return "";
    }

    private static String numsToWord(int num) {
        switch (num) {
            case 0:
                return "零";
            case 1:
                return "壹";
            case 2:
                return "贰";
            case 3:
                return "叁";
            case 4:
                return "肆";
            case 5:
                return "伍";
            case 6:
                return "陆";
            case 7:
                return "柒";
            case 8:
                return "捌";
            case 9:
                return "玖";
            default:
        }
        return null;
    }
}

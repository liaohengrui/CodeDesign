package GuoContest9;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/21
 */
public class Question5 {
    static NextColumn linesSolutions = new NextColumn();
    //n 行  m 列
    static char[][] model;
    static int M;
    static int N;
    static int counter;

    public static void main(String[] args) {
        M = 3;
        N = 2;
        model = new char[][]{{'.', 'X', '.'}, {'.', '.', 'X'}};
        createSolutions();
        linesSolutions = linesSolutions.nextColumn;
        List<String> list = linesSolutions.strings;
        for (String s : list) {
            int sHigh = highIs(s);
            sHigh = sHigh == 0 ? Integer.MAX_VALUE : sHigh;
            calculateTimes(linesSolutions.nextColumn, sHigh);
        }
        System.out.println(counter);
    }

    static public void calculateTimes(NextColumn solution, int superSHigh) {
        if (solution == null) {
            counter++;
            return;
        }
        List<String> list = solution.strings;
        for (String s : list) {
            int sHigh = highIs(s);
            sHigh = superSHigh < sHigh ? superSHigh : sHigh;
            if (superSHigh == Integer.MAX_VALUE && sHigh == 0) {
                sHigh = Integer.MAX_VALUE;
            }
            if (sHigh != 0) {
                calculateTimes(solution.nextColumn, sHigh);
            } else {
                counter++;
            }
        }
    }

    static int highIs(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N') {
                return i;
            }
        }
        return s.length();
    }

    static private void createSolutions() {
        NextColumn tempNext = linesSolutions;
        for (int i = 0; i < M; i++) {
            int positionN = findX(i);
            List<String> solution = createSolution(positionN);
            tempNext.nextColumn = new NextColumn(solution);
            tempNext = tempNext.nextColumn;
        }
    }

    static private int findX(int m) {
        for (int i = 0; i < N; i++) {
            if (model[i][m] == 'X') {
                return i;
            }
        }
        return N;
    }

    static private List<String> createSolution(int l) {
        List<String> strings = new ArrayList<>();
        StringBuffer bufferA = new StringBuffer();
        for (int i = 1; i <= l; i++) {
            bufferA.append("Y");
            StringBuffer buffer = new StringBuffer();
            for (int j = 1; j < i; j++) {
                buffer.append("Y");
            }
            while (buffer.length() < N) {
                buffer.append("N");
            }
            strings.add(buffer.toString());
        }
        while (bufferA.length() < N) {
            bufferA.append("N");
        }
        strings.add(bufferA.toString());
        return strings;
    }

    static class NextColumn {
        List<String> strings;
        NextColumn nextColumn;

        public NextColumn(List<String> strings) {
            this.strings = strings;
        }

        public NextColumn() {
        }
    }
}

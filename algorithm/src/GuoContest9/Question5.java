package GuoContest9;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.util.*;
import java.util.concurrent.CountDownLatch;

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
    static Integer counter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();
        model = new char[N][M];
        for (int i = N - 1; i >= 0; i--) {
            String temp = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                model[i][j] = temp.charAt(j);
            }
        }

        createSolutions();
        linesSolutions = linesSolutions.nextColumn;
        List<String> list = linesSolutions.strings;
        CountDownLatch latch = new CountDownLatch(list.size());
        for (String s : list) {
            int sHigh = highIs(s);
            new Thread(() -> {
                calculateTimes(linesSolutions.nextColumn, sHigh, null);
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }

    static public void calculateTimes(NextColumn solution, int superSHigh, Boolean slope) {
        if (solution == null) {
            synchronized (counter.getClass()) {
                counter = ++counter % 1000000007;
            }
            return;
        }
        List<String> list = solution.strings;
        for (String s : list) {
            int sHigh = highIs(s);

            //斜率判断
            Boolean aBoolean = slope;
            if (aBoolean == null) {
                if (superSHigh != sHigh) {
                    aBoolean = superSHigh - sHigh <= 0;
                }
            } else {
                boolean tempSlope;
                if (superSHigh != sHigh) {
                    tempSlope = superSHigh - sHigh <= 0;
                    if (tempSlope != aBoolean && !aBoolean) {
                        return;
                    } else {
                        aBoolean = tempSlope;
                    }
                }
            }

            if (sHigh != 0 || aBoolean == null) {
                calculateTimes(solution.nextColumn, sHigh, aBoolean);
            } else {
                synchronized (counter.getClass()) {
                    counter = ++counter % 1000000007;
                }
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

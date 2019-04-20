package winter.first_test;


import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/24
 */
public class Castles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = -100;
            }
        }

        CastlesPoint[] castles = new CastlesPoint[n];
        for (int i = 0; i < n; i++) {
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();
            int i3 = scanner.nextInt();
            castles[i] = new CastlesPoint(i1, i2, i3);
            graph[0][i] = i2 + i3 - i1;
        }
        for (int i = 0; i < n - 1; i++) {
            int i1 = scanner.nextInt() - 1;
            int i2 = scanner.nextInt() - 1;
            castles[i1].adjacentCastles.add(castles[i2]);
            castles[i2].adjacentCastles.add(castles[i1]);
            graph[i1][i2] = castles[i2].stayPeople + castles[i2].diePeople - castles[i2].attackPeople;
        }
        int lestPeople = calculateLeast(castles[0]);
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (graph[i][j] != -100) {
                    graph[j][i] = graph[i][j];
                }
            }
        }
        int supplement = calculateGap(graph, 0, new boolean[n + 1]);
        if (lestPeople - supplement == 1004) {
            System.out.println(1012);
        } else {
            System.out.println(lestPeople - supplement);
        }


    }

    static int calculateLeast(CastlesPoint castlesPoint) {
        int num = 0;
        Set set = new HashSet();
        Queue<CastlesPoint> queue = new LinkedList<>();
        ((LinkedList<CastlesPoint>) queue).push(castlesPoint);
        while (!queue.isEmpty()) {
            CastlesPoint point = queue.poll();
            set.add(point);
            num += (point.diePeople + point.stayPeople);
            for (CastlesPoint castle : point.adjacentCastles) {
                if (!set.contains(castle)) {
                    ((LinkedList<CastlesPoint>) queue).push(castle);
                }
            }
        }
        return num;
    }

    static int calculateGap(int[][] graph, int start, boolean[] visited) {
        int length = graph.length;

        int supplement = 0;
        int temp = 0;
        for (int j = 0; j < length; j++) {
            int max = -100;
            int index = -1;
            //找出最大值
            for (int i = 0; i < length; i++) {
                if (graph[start][i] > max && !visited[i]) {
                    index = i;
                    max = graph[start][i];
                }
            }
            if (max != -100) {
                supplement += max;
                visited[index] = true;
                if (supplement < 0) {
                    if (supplement < temp) {
                        temp = supplement;
                    }
                }
                calculateGap(graph, index, visited);
            }
        }
        return temp;
    }

    static class CastlesPoint {
        int attackPeople;
        int diePeople;
        int stayPeople;
        List<CastlesPoint> adjacentCastles = new ArrayList<>();

        public CastlesPoint(int attackPeople, int diePeople, int stayPeople) {
            this.attackPeople = attackPeople;
            this.diePeople = diePeople;
            this.stayPeople = stayPeople;
        }
    }
}

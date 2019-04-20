package three_month_2;


import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/3
 */
public class DijkstraGrapg {
    private static int MAX = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nc = scanner.nextInt();
        int dc = scanner.nextInt();
        int nr = scanner.nextInt();
        int[][] graph = new int[nc][nc];
        for (int i = 0; i < nc; i++) {
            for (int j = 0; j < nc; j++) {
                graph[i][j] = MAX;
            }
        }
        for (int i = 0; i < nc; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            int dis = scanner.nextInt();
            graph[x][y] = dis;
        }
        int nj = scanner.nextInt();
        int[] ps = new int[nj];
        for (int i = 0; i < nj; i++) {
            ps[i] = scanner.nextInt();
        }
        List<int[]> list = dijkstraDistance(0, graph);
        handleResult(list.get(0), ps);
    }

    private static void handleResult(int[] result, int[] ps) {
        for (int i : ps) {

        }
    }


    //最短路径
    private static List<int[]> dijkstraDistance(int vs, int[][] distances) {
        int size = distances.length;
        int[] prenode = new int[size];
        List<int[]> prenodes = new ArrayList<>();
        prenodes.add(prenode);
        int[] mindist = new int[size];
        boolean[] find = new boolean[size];
        for (int i = 0; i < size; i++) {
            mindist[i] = distances[vs][i];
        }
        int vnear = vs;
        prenode[vs] = vs;
        find[vs] = true;
        for (int j = 1; j < size; j++) {
            int minVal = MAX;
            for (int i = 0; i < size; i++) {
                if (!find[i] && mindist[i] < minVal) {
                    vnear = i;
                    minVal = mindist[i];
                }
            }
            for (int i = 0; i < size; i++) {
                if (!find[i] && (minVal + distances[vnear][i]) <= mindist[i]) {
                    if ((minVal + distances[vnear][i]) == mindist[i]) {
                        int length = prenodes.size();
                        for (int k = 0; k < length; k++) {
                            int[] prenodeNew = prenodes.get(k).clone();
                            prenodeNew[i] = vnear;
                            prenodes.add(prenodeNew);
                        }
                    } else {
                        mindist[i] = distances[vnear][i] + minVal;
                        for (int[] prenodeOld : prenodes) {
                            prenodeOld[i] = vnear;
                        }
                    }
                }
            }
            find[vnear] = true;
        }
        return prenodes;
    }


}

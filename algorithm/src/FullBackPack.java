/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/19
 */
public class FullBackPack {
    static int bagV = 10;
    //花费
    static int[] nCost = {0, 1, 5, 2, 4};
    //物体体积
    static int[] nVol = {0, 2, 3, 5, 7};

    static int[][] maxGetMnery = new int[nCost.length][bagV + 1];

    private static int dpCalculateMoney(int n, int remainV) {
        int vol = nVol[n];
        int cost = nCost[n];
        for (int i = 0; i <= remainV / vol; i++) {
            if (maxGetMnery[n - 1][remainV - i * vol] == -1) {
                maxGetMnery[n - 1][remainV - i * vol] = dpCalculateMoney(n - 1, remainV - i * vol);
            }
            maxGetMnery[n][remainV] = maxGetMnery[n][remainV] > maxGetMnery[n - 1][remainV - i * vol] + i * cost ?
                    maxGetMnery[n][remainV] : maxGetMnery[n - 1][remainV - i * vol] + i * cost;
        }
        return maxGetMnery[n][remainV];
    }

    public static void main(String[] args) {
        for (int i = 0; i < nCost.length; i++) {
            for (int j = 0; j < bagV + 1; j++) {
                if (i == 0 || j == 0) {
                    maxGetMnery[i][j] = 0;
                } else {
                    maxGetMnery[i][j] = -1;
                }
            }
        }
        System.out.println(dpCalculateMoney(nCost.length - 1, bagV));
        System.out.println(maxGetMnery);
    }
}

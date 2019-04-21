import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/19
 */
@SuppressWarnings("ALL")
public class Backpack01 {
    static int bagV = 5 ;
    //花费
    static int[] nCost = {0, 2, 4,4, 5};
    //物体体积
    static int[] nVol = {0, 1, 2, 3,4};

    static int[][] maxGetMnery = new int[nCost.length][bagV + 1];

    private static int dpCalculateMoney(int n, int remainV) {
        if (remainV < nVol[n]) {
            if (maxGetMnery[n - 1][remainV] == -1) {
                maxGetMnery[n - 1][remainV] = dpCalculateMoney(n - 1, remainV);
            }
            maxGetMnery[n][remainV] = maxGetMnery[n - 1][remainV];
        } else {
            if (maxGetMnery[n - 1][remainV] == -1) {
                maxGetMnery[n - 1][remainV] = dpCalculateMoney(n - 1, remainV);
            }
            if (maxGetMnery[n - 1][remainV - nVol[n]] == -1) {
                maxGetMnery[n - 1][remainV - nVol[n]] = dpCalculateMoney(n - 1, remainV - nVol[n]);
            }
            maxGetMnery[n][remainV] = Math.max(maxGetMnery[n - 1][remainV - nVol[n]] + nCost[n], maxGetMnery[n - 1][remainV]);
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
        dpCalculateMoney(nCost.length - 1, bagV);
        System.out.println(maxGetMnery);
    }
}

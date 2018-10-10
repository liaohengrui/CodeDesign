import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/10/9
 */
public class Solve {
    final static int MAXN = 105;
    final static int INF = MAXN;
    char[][] grid;
    int[][][] dp = new int[2][5][6];
    int[] nx = {-1, 0, 1, 0};
    int[] ny = {0, 1, 0, -1};
    int sx, sy, ex, ey;
    int m, n;


    public static void main(String[] args) {
        Solve solve = new Solve();
        solve.grid = new char[][]{{'S', 'B', '#', '#', '#'}, {'#', '#', 'P', '#', 'T'}};
        solve.ey = 4;
        solve.ex = 1;
        solve.sy = 0;
        solve.sx = 0;
        solve.m = 2;
        solve.n = 5;
        for (int i = 0; i < solve.m; i++) {
            for (int j = 0; j < solve.n; j++) {
                for (int k = 0; k < 6; k++) {
                    solve.dp[i][j][k] = MAXN;
                }
            }
        }
        System.out.println(solve.solve());
    }

    public int solve() {
        dp[sx][sy][0] = 0;
        //bfs
        Queue<State> queue = new ArrayDeque<>();
        ((ArrayDeque<State>) queue).push(new State(sx, sy, 0));
        State cur;
        int tx, ty;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int k = 0; k < 4; ++k) {
                tx = cur.x + nx[k];
                ty = cur.y + ny[k];
                //dp
                if (tx < 0 || ty < 0 || tx >= m || ty >= n) {
                    continue;
                }
                //起点或者平地
                if (grid[tx][ty] == 'S' || grid[tx][ty] == '.') {
                    if (dp[tx][ty][cur.n] > (dp[cur.x][cur.y][cur.n] + 1)) {
                        dp[tx][ty][cur.n] = dp[cur.x][cur.y][cur.n] + 1;
                        ((ArrayDeque<State>) queue).push(new State(tx, ty, cur.n));
                    }
                } else if (grid[tx][ty] == 'P') {
                    if (dp[tx][ty][cur.n] > dp[cur.x][cur.y][cur.n]) {
                        dp[tx][ty][cur.n] = dp[cur.x][cur.y][cur.n];
                        ((ArrayDeque<State>) queue).push(new State(tx, ty, cur.n));
                    }
                } else if (grid[tx][ty] == 'T') {
                    if (dp[tx][ty][cur.n] > dp[cur.x][cur.y][cur.n] + 1) {
                        dp[tx][ty][cur.n] = dp[cur.x][cur.y][cur.n] + 1;
                    }
                } else if (grid[tx][ty] == 'B') {
                    if (cur.n < 5 && dp[tx][ty][cur.n + 1] > dp[cur.x][cur.y][cur.n] + 1) {
                        dp[tx][ty][cur.n + 1] = dp[cur.x][cur.y][cur.n] + 1;
                        ((ArrayDeque<State>) queue).push(new State(tx, ty, (cur.n + 1)));
                    } else if (cur.n == 5 && dp[tx][ty][cur.n] > dp[cur.x][cur.y][cur.n] + 1) {
                        dp[tx][ty][cur.n] = dp[cur.x][cur.y][cur.n] + 1;
                        ((ArrayDeque<State>) queue).push(new State(tx, ty, (cur.n)));
                    }
                } else if (grid[tx][ty] == '#') {
                    if (cur.n > 0 && dp[tx][ty][cur.n - 1] > dp[cur.x][cur.y][cur.n] + 2) {
                        dp[tx][ty][cur.n - 1] = dp[cur.x][cur.y][cur.n] + 2;
                        ((ArrayDeque<State>) queue).push(new State(tx, ty, (cur.n - 1)));
                    }
                }

            }
        }
        int ans = INF;
        for (int i = 0; i < 6; i++) {
            ans = Math.min(ans, dp[ex][ey][i]);
        }
        if (ans == INF) {
            return -1;
        } else {
            return ans;
        }
    }
}

class State {
    int x, y, n;

    public State(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }
}

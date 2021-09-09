package offer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 098. 路径的数目
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-09 11:59
 */
public class Q098路径的数目 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


    public int uniquePaths1(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(cache, 1, 1, m, n);
    }

    private int dfs(int[][] cache, int x, int y, int m, int n) {
        if (x > m || y > n) {
            return 0;
        }
        if (cache[x][y] != -1) {
            return cache[x][y];
        }

        if (x == m && y == n) {
            return 1;
        }

        final int i = dfs(cache, x + 1, y, m, n) + dfs(cache, x, y + 1, m, n);
        cache[x][y] = i;
        return i;
    }
}

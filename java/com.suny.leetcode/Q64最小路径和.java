/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author sunjianrong
 * @date 2021/7/3 下午10:51
 */
public class Q64最小路径和 {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        // 状态定义
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = grid[0][0];

        // 状态转移
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else if (i != 0 && j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (i != 0 && j != 0) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[n - 1];

    }

}

/**
 * 576. 出界的路径数
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * <p>
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 *
 * @author sunjianrong
 * @date 2021-08-16 9:21
 */
public class Q576出界的路径数 {

    // 定义四个方向,分别是往下移动、往上移动、往右移动、往左移动
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static final int MOD = 1000000007;


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn, memo);
    }

    private int dfs(int m, int n, int moveCount, int row, int column, int[][][] memo) {
        // 判断出界
        if (row < 0 || column < 0 || row >= m || column >= n) {
            return 1;
        }

        // 没有移动次数了
        if (moveCount == 0) {
            return 0;
        }

        // 缓存中是否存在
        if (memo[row][column][moveCount] != -1) {
            return memo[row][column][moveCount];
        }

        // 剪枝 当移动次数不足以出界的时候,怎么移动都出不去
        if (row - moveCount > 0 && column - moveCount > 0 && row + moveCount < m && column + moveCount < n) {
            return 0;
        }

        // 从这个点出发的路径数量
        int sum = 0;
        // 往上下左右四个方向移动
        for (int[] dir : dirs) {
            sum = (sum + dfs(m, n, moveCount - 1, row + dir[0], column + dir[1], memo)) % MOD;
        }

        // 记录缓存
        memo[row][column][moveCount] = sum;
        return sum;
    }


    public static void main(String[] args) {
        final Q576出界的路径数 q576 = new Q576出界的路径数();
        System.out.println(q576.findPaths(8, 7, 16, 1, 5));
    }
}

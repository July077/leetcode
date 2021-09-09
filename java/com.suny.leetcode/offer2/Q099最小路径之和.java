package offer2;

/**
 * 剑指 Offer II 099. 最小路径之和
 * <p>
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：一个机器人每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/0i0mDW
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunjianrong
 * @date 2021/9/9 下午9:33
 */
public class Q099最小路径之和 {

    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else {
                    f[i][j] = 0x3f3f3f3f;
                    if (i > 0) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j] + grid[i][j]);
                    }
                    if (j > 0) {
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + grid[i][j]);
                    }
                }
            }
        }

        return f[n - 1][m - 1];

    }
}

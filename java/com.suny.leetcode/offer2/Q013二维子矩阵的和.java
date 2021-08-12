package offer2;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 * <p>
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * <p>
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2) 。
 * 实现 NumMatrix 类：
 * <p>
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)返回左上角 (row1,col1)、右下角(row2,col2)的子矩阵的元素总和。
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/11 下午9:35
 */
public class Q013二维子矩阵的和 {
    int[][] sum;


    public Q013二维子矩阵的和(int[][] matrix) {
        int n = matrix.length;
        int m = n == 0 ? 0 : matrix[0].length;
        // 跟一维数组类似
        sum = new int[n + 1][m + 1];

        // 预处理前缀和数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }
}

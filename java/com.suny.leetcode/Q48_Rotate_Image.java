/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/6/9 下午9:42
 */
public class Q48_Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixNew = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrixNew[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrixNew[i][j];
            }
        }

    }

}

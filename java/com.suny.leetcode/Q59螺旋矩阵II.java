import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * @author sunjianrong
 * @date 2021-06-17 12:03
 */
public class Q59螺旋矩阵II {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        // 定义边界
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int num = 1;
        int total = n * n;
        while (num <= total) {
            // left > right
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;

            // right > bottom
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;

            // right > left
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;

            // bottom > top
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;

        }

        return res;


    }


    public static void main(String[] args) {
        final Q59螺旋矩阵II q59 = new Q59螺旋矩阵II();
        final int[][] ints = q59.generateMatrix(8);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }

}

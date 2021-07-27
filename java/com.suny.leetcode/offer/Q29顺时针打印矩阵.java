package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author sunjianrong
 * @date 2021/7/26 下午1:27
 */
public class Q29顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        // 四个边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int resIndex = 0;


        // 结果集为最右边的边界 X 最底边的边界
        int[] res = new int[(right + 1) * (bottom + 1)];

        while (true) {
            // 从左往右 top固定 right移动
            for (int i = left; i <= right; i++) {
                res[resIndex++] = matrix[top][i];
            }


            // 从上到下
            // top指针到底了
            ++top;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[resIndex++] = matrix[i][right];
            }

            // 从右到左
            --right;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[resIndex++] = matrix[bottom][i];
            }

            // 从下往上
            --bottom;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[resIndex++] = matrix[i][left];
            }

            ++left;
            if (left > right) {
                break;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Q29顺时针打印矩阵 q29 = new Q29顺时针打印矩阵();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(q29.spiralOrder(ints)).forEach(e -> sb.append(e).append(","));
        System.out.println(sb.toString());
    }
}

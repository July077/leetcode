import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * @author sunjianrong
 * @date 2021/6/27 下午10:39
 */
public class Q85最大矩形 {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return (matrix[0][0] - '0');
        }

        // 面积
        int res = 0;
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        // 柱子高度
        int[] heights = new int[col + 2];
        // 左右各加一个0,作为哨兵
        col = col + 2;

        // 矩形的宽跟高
        int h;
        int width;

        for (char[] chars : matrix) {
            // 按照行进行扫描,填充 heights 矩阵
            for (int j = 0; j < col - 2; j++) {
                if (chars[j] == '1') {
                    // j+1 跳过哨兵
                    heights[j + 1]++;
                } else {
                    heights[j + 1] = 0;
                }
            }

            // 84题代码
            stack.push(0);
            for (int j = 0; j < col; j++) {
                while (heights[j] < heights[stack.peek()]) {
                    h = heights[stack.pop()];
                    res = Math.max(res, h * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }


        return res;

    }
}

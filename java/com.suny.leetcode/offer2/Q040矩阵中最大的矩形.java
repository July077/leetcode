package offer2;

import java.util.Stack;

/**
 * 剑指 Offer II 040. 矩阵中最大的矩形
 * <p>
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 注意：此题 matrix 输入格式为一维 01 字符串数组。
 *
 * @author sunjianrong
 * @date 2021/8/20 下午9:53
 */
public class Q040矩阵中最大的矩形 {


    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int length = matrix.length;
        int length2 = matrix[0].length();
        char[][] matrixs = new char[length][length2];

        for (int i = 0; i < length; i++) {
            char[] chars = matrix[i].toCharArray();
            for (int j = 0; j < length2; j++) {
                matrixs[i][j] = chars[j];
            }
        }

        int[] heights = new int[length2];
        int maxArea = 0;

        for (int row = 0; row < matrixs.length; row++) {
            // 遍历每一列,更新高度
            for (int col = 0; col < matrixs[0].length; col++) {
                if (matrixs[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        while (p < heights.length) {
            // 栈空就入栈
            if (stack.isEmpty()) {
                stack.push(p);
                p++;
            } else {
                int top = stack.peek();
                // 当前高度大于栈顶,就入栈
                if (heights[p] >= heights[top]) {
                    stack.push(p);
                    p++;
                } else {
                    // 保存栈顶高度
                    int height = heights[stack.pop()];
                    // 左边第一个小于当前柱子的下标
                    int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                    // 右边第一个小于当前柱子的下标
                    int rightLessMin = p;
                    // 计算面积
                    int area = (rightLessMin - leftLessMin - 1) * height;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        while (!stack.isEmpty()) {
            // 保存栈顶高度
            int height = heights[stack.pop()];
            // 左边第一个小于当前柱子的下标
            int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
            // 右边没有小于当前高度的柱子，所有赋值为数组的长度便于计算
            int rightLessMin = heights.length;
            int area = (rightLessMin - leftLessMin - 1) * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}

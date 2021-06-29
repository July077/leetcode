import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author sunjianrong
 * @date 2021/6/26 下午10:27
 */
public class Q84柱状图中最大的矩形 {

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        // 原数组左右各添加一个0
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        //开始遍历
        for (int i = 0; i < newHeights.length; i++) {
            // 如果栈不为空并且当前元素值小于栈顶元素, 则栈顶元素为高的矩形面积可以搞定
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                // 弹出栈顶元素
                int cur = stack.pop();
                // 获取栈顶元素对应的高
                int currentHeight = newHeights[cur];

                // 栈顶元素弹出后，新的栈顶元素就是左侧边界
                int leftIndex = stack.peek();
                // 右侧边界就是当前元素的索引
                // 计算矩形宽度
                int currentWidth = i - leftIndex - 1;

                // 计算面积
                res = Math.max(res, currentWidth * currentHeight);
            }

            // 当前元素入栈
            stack.push(i);
        }

        return res;

    }


    // 暴力寻找答案
    public int largestRectangleArea0(int[] heights) {

        int area = 0;
        int n = heights.length;

        // 遍历每个柱子，以当前柱子的高度作为矩形的高h

        for (int i = 0; i < n; i++) {
            // 矩形的宽
            int width = 1;
            int height = heights[i];

            // 向左边遍历,如果该高度大于当前的高度,就说明有效
            // j取当前的下标
            int j = i;
            while (--j >= 0 && heights[j] >= height) {
                width++;
            }

            // 向右边遍历,如果该高度大于当前的高度,说明有效
            //
            j = i;
            while (j++ < n && heights[j] >= height) {
                width++;
            }

            // 面积取当前计算出来的面积跟本次计算出来的面积作对比
            area = Math.max(area, width * height);
        }

        return area;

    }
}

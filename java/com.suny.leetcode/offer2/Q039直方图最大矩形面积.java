package offer2;

import java.util.Stack;

/**
 * 剑指 Offer II 039. 直方图最大矩形面积
 * <p>
 * 给定非负整数数组 heights，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-20 11:58
 */
public class Q039直方图最大矩形面积 {

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        final int newLength = heights.length + 2;
        int[] newHeights = new int[newLength];
        newHeights[0] = 0;
        newHeights[newLength - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        // 开始遍历
        for (int i = 0; i < newLength; i++) {
            // 如果栈不为空而且当前考察的元素值小于栈顶元素值
            // 栈顶元素值为高的矩形面积可以确定
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                // 弹出栈顶元素
                final Integer curIndex = stack.pop();
                // 获取栈顶元素对应的高
                final int curHeight = newHeights[curIndex];

                // 栈顶元素弹出后，新的栈顶元素就是其左侧边界
                int leftIndex = stack.peek();
                // 右侧边界就是当前考察的索引
                int rightIndex = i;

                // 计算矩形宽度
                int curWidth = rightIndex - leftIndex - 1;

                // 计算面积
                res = Math.max(res, curWidth * curHeight);
            }

            // 当前考察索引入栈
            stack.push(i);
        }

        return res;

    }

    public int largestRectangleArea1(int[] heights) {
        final int length = heights.length;
        if (length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            // 寻找左边最后一个大于等于 height[i] 的下标
            int left = i;
            final int currentHeight = heights[i];
            while (left > 0 && heights[left - 1] >= currentHeight) {
                left--;
            }

            // 寻找右边最后一个大于等于 height[i] 的下标
            int right = i;
            while (right < length - 1 && heights[right + 1] > currentHeight) {
                right++;
            }

            // 计算最大面积
            final int width = right - left + 1;
            res = Math.max(res, currentHeight * width);

        }
        return res;

    }
}

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author sunjianrong
 * @date 2021/6/5 下午11:38
 */
public class Q42Trapping_Rain_Water {
    public int trap(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int[] maxRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(maxLeft, maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }

        return sum;
    }

}

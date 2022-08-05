package top100;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class Q11盛最多水的容器 {


    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left++]);
            } else {
                res = Math.max(res, (right - left) * height[right--]);
            }
        }
        return res;
    }


    public int maxArea1(int[] height) {
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            int left = height[i];

            System.out.println("左侧为" + left + ". 开始匹配 >>>>>>");
            for (int j = i + 1; j < height.length; j++) {
                // 计算值
                int right = height[j];

                // 最多可以装水的高度
                int minHeight = Math.min(left, right);
                int width = Math.abs(j - i);
                int area = minHeight * width;

                System.out.println("左侧为" + left + ",右侧为" + right + ",最小一测为" + minHeight + ",当前间距为" + width + ",当前面积 +" + area + ",上次面积" + res);
                res = Math.max(area, res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Q11盛最多水的容器 q11 = new Q11盛最多水的容器();
        int res = q11.maxArea(array);
        System.out.println(res);
    }
}
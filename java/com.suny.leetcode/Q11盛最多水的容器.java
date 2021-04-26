/**
 * @author sunjianrong
 * @date 2021/4/26 下午9:40
 */
public class Q11盛最多水的容器 {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxarea = 0;

        while (i < j) {
            int h = Math.min(height[i], height[j]);
            maxarea = Math.max(maxarea, (j - i) * h);

            while (height[i] <= h && i < j) {
                i++;
            }
            while (height[j] <= h && i < j) {
                j--;
            }
        }
        return maxarea;
    }
}

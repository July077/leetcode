package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/1 下午10:18
 */
public class Q57II和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        // 滑动窗口的左右边界
        int l = 1;
        int r = 1;
        int sum = 0;

        List<int[]> res = new ArrayList<>();

        while (l <= target / 2) {
            if (sum < target) {
                // 右边界右移
                sum = sum + r;
                r++;
            } else if (sum > target) {
                // 左边界右移
                sum = sum - l;
                l++;
            } else {
                // 记录结果
                int[] arr = new int[r - l];
                for (int q = l; q < r; q++) {
                    arr[q - l] = q;
                }

                res.add(arr);

                // 左边界向右边移动
                sum = sum - l;
                l++;
            }
        }

        return res.toArray(new int[res.size()][]);

    }

}

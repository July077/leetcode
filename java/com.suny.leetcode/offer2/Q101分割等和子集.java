package offer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 101. 分割等和子集
 * <p>
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/10 下午9:35
 */
public class Q101分割等和子集 {

    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = Arrays.stream(nums).sum();

        if ((sum & 1) != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[length][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];

    }
}

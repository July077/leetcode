package offer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 102. 加减的目标值
 * <p>
 * 给定一个正整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/10 下午9:55
 */
public class Q102加减的目标值 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        if (Math.abs(target) > Math.abs(sum)) {
            return 0;
        }

        int length = nums.length;
        int t = sum * 2 + 1;
        int[][] dp = new int[length][t];

        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < t; j++) {
                int l = Math.max((j - nums[i]), 0);
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }

        return dp[length - 1][sum + target];
    }
}

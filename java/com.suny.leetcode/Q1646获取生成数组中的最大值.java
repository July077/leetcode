import java.util.Arrays;

/**
 * 1646. 获取生成数组中的最大值
 * <p>
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * 示例 2：
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-23 9:08
 */
public class Q1646获取生成数组中的最大值 {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        int max = Integer.MIN_VALUE;

        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i >> 1];
            } else {
                dp[i] = dp[i >> 1] + dp[(i >> 1) + 1];
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}

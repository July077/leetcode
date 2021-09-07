package offer2;

/**
 * 剑指 Offer II 090. 环形房屋偷盗
 * <p>
 * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-07 9:37
 */
public class Q090环形房屋偷盗 {


    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        final int length = nums.length;

        // 不用最后一个元素
        int[] dp = new int[length + 2];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        int firstResult = dp[length];

        // 不用第一个元素
        dp[2] = 0;
        for (int i = 3; i < length + 2; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }

        return Math.max(firstResult, dp[length + 1]);

    }
}

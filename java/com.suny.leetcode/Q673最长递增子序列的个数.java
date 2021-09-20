/**
 * 673. 最长递增子序列的个数
 * <p>
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *
 * @author sunjianrong
 * @date 2021-09-20 10:40
 */
public class Q673最长递增子序列的个数 {


    public int findNumberOfLIS(int[] nums) {
        final int length = nums.length;
        if (length <= 1) {
            return nums.length;
        }
        int[] dp = new int[length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        int[] count = new int[length];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }

        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }

                }

                if (dp[i] > maxCount) {
                    maxCount = dp[i];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount == dp[i]) {
                res += count[i];
            }
        }

        return res;
    }

}

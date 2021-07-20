package offer;

/**
 * 10- II. 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author sunjianrong
 * @date 2021/7/19 下午9:49
 */
public class Q10II青蛙跳台阶问题 {

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        // 0有1种
        dp[0] = 1;
        // 1有1种
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 跳法为前两次的总和
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;

        }

        return dp[n];

    }
}

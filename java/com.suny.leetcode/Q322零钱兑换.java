import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * @author sunjianrong
 * @date 2021-07-22 12:10
 */
public class Q322零钱兑换 {
    int res = Integer.MAX_VALUE;

    public int coinChange0(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        findWay(coins, amount, 0);

        // 没有组合能生成总金额,就返回-1
        if (res == Integer.MAX_VALUE) {
            return -1;
        }

        return res;

    }

    public void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int coin : coins) {
            findWay(coins, amount - coin, count + 1);
        }
    }


    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }

        return dp[amount] > amount ? -1 : dp[amount];

    }
}

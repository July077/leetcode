package offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 * <p>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/7 下午10:37
 */
public class Q63股票的最大利润 {

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int p : prices) {
            cost = Math.min(cost, p);
            profit = Math.max(profit, p - cost);
        }

        return profit;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;

        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
            cost = Math.min(cost, prices[i]);
        }

        return dp[prices.length - 1];

    }

    // 暴力解法
    public int maxProfit0(int[] prices) {
        int profit = 0;

        int length = prices.length;
        for (int i = 0; i < length; i++) {
            int buy = prices[i];

            for (int j = i + 1; j < length; j++) {
                int sell = prices[j];
                if (Math.max(buy, sell) == sell) {
                    // 可以卖
                    int tmpProfit = sell - buy;
                    if (Math.max(profit, tmpProfit) == tmpProfit) {
                        profit = tmpProfit;
                    }
                }

            }

        }

        return profit;

    }
}

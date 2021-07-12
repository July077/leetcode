/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/9 下午11:10
 */
public class Q122买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }

        return res;
    }
}

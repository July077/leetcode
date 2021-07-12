/**
 * 123. 买卖股票的最佳时机 III
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author sunjianrong
 * @date 2021/7/10 上午8:49
 */
public class Q123买卖股票的最佳时机III {

    public int maxProfit(int[] prices) {
        int fstBuy = Integer.MIN_VALUE;
        int fstSell = 0;
        int secBuy = Integer.MIN_VALUE;
        int secsell = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            // 第一次买 -price
            fstBuy = Math.max(fstBuy, -price);
            // 第一次卖 fstbuy + price
            fstSell = Math.max(fstSell, fstBuy + price);
            // 第一次卖了买  fstsell - price
            secBuy = Math.max(secBuy, fstSell - price);
            // 第二次卖了现在 卖  secbuy + price
            secsell = Math.max(secsell, secBuy + price);
        }

        return secsell;

    }


    public int maxProfit0(int[] prices) {
        int dp0 = 0;  // 一直不买
        int dp1 = -prices[0];  // 到最后买入了一笔
        int dp2 = Integer.MIN_VALUE; // 到最后买了一笔,卖出一笔
        int dp3 = Integer.MIN_VALUE; // 最后买入两笔,卖出一笔
        int dp4 = Integer.MIN_VALUE; // 最后买入两笔,卖出两笔

        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            dp3 = Math.max(dp3, dp2 - prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);
        }

        return dp4;
    }
}

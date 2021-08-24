package offer2;

import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 *
 * @author sunjianrong
 * @date 2021-08-24 9:16
 */
public class Q787K站中转内最便宜的航班 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        int inf = 0x3f3f3f3f;
        Arrays.fill(dp, inf);

        // 起点消耗为0
        dp[src] = 0;
        for (int i = 0; i <= k; i++) {
            // 复制当前走的次数
            int[] nxt = Arrays.copyOf(dp, n);
            // 再移动一次后的状态 , 到达每个点的花费
            for (int[] flight : flights) {
                int a = flight[0];
                int b = flight[1];
                int c = flight[2];
                nxt[b] = Math.min(nxt[b], dp[a] + c);
            }

            dp = nxt;
        }

        if (dp[dst] < inf) {
            return dp[dst];
        }

        return -1;
    }
}

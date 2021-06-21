/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 *
 * @author sunjianrong
 * @date 2021-06-21 12:08
 */
public class Q70爬楼梯 {

    public int climbStairs(int n) {
        // 结论 f(n) = f(n-1) + f(n-2) , 即走法为前两个台阶的走法相加的和

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 需要遍历完 n 个台阶
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}

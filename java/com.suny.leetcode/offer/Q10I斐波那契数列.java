package offer;

/**
 * 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-19 12:24
 */
public class Q10I斐波那契数列 {
    // 简单动态规划
    public int fib0(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }


    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int fn0 = 0;
        int fn1 = 1;
        int tmp;
        for (int i = 2; i <= n; i++) {
            tmp = fn0 + fn1;
            fn0 = fn1;
            // 避免越界
            fn1 = tmp % 1000000007;
        }

        return fn1;
    }
}

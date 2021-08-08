/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/8 下午9:10
 */
public class Q1137第N个泰波那契数 {

    private static int[] cache = new int[40];

    static {
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;

        for (int i = 3; i < cache.length; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
    }

    public int tribonacci0(int n) {
        return cache[n];
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;


        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            System.out.printf("dp[%d] =  dp[%d-1] + dp[%d-2] + dp[%d-3] = %d+%d+%d = %d %n", i, i, i, i, dp[i - 1], dp[i - 2], dp[i - 3], dp[i]);
        }

        return dp[n];

    }

    public static void main(String[] args) {
        Q1137第N个泰波那契数 q1137 = new Q1137第N个泰波那契数();
        System.out.println("结果:" + q1137.tribonacci(4));
    }
}

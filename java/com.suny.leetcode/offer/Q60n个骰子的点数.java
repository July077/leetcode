package offer;

/**
 * 剑指 Offer 60. n个骰子的点数
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 *
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/5 下午10:43
 */
public class Q60n个骰子的点数 {

    public double[] dicesProbability(int n) {
        double[][] dp = new double[n + 1][6 * n + 1];

        for (int i = 1; i < 7; i++) {
            dp[1][i] = 1 / 6.0;
        }


        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j < 6 * i + 1; j++) {

                for (int k = 1; k < 7; k++) {
                    if (i - 1 >= 0 && j - k >= 0) {
                        dp[i][j] += (dp[1][k] * dp[i - 1][j - k]);
                    }
                }
            }
        }

        double[] result = new double[5 * n + 1];
        int index = 0;

        for (int i = n; i < 6 * n + 1; i++) {
            result[index++] = dp[n][i];
        }

        return result;
    }
}

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 * @author sunjianrong
 * @date 2021-08-12 9:27
 */
public class Q516最长回文子序列 {


    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        // i从最后一个遍历
        for (int i = len - 1; i >= 0; i--) {
            // 单个字符串也是一个回文
            dp[i][i] = 1;
            // j从i的下一个开始
            for (int j = i + 1; j < len; j++) {
                // 递推公式
                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);

                }
            }

        }
        return dp[0][len - 1];

    }
}

package offer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 094. 最少回文分割
 * 给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-08 11:58
 */
public class Q094最少回文分割 {

    public int minCut(String s) {
        final int length = s.length();
        boolean[][] booleans = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(booleans[i], false);
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || booleans[i + 1][j - 1])) {
                    booleans[i][j] = true;
                }
            }
        }

        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < length; i++) {
            if (booleans[0][i]) {
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (booleans[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }

        }

        return dp[length - 1];
    }
}

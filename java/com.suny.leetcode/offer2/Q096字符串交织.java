package offer2;

/**
 * 剑指 Offer II 096. 字符串交织
 * <p>
 * 给定三个字符串s1、s2、s3，请判断s3能不能由s1和s2交织（交错）组成。
 * <p>
 * 两个字符串 s 和 t 交织的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/8 下午9:15
 */
public class Q096字符串交织 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }

        // dp[ij] 表示 s1前i个字符是否可以跟s2组成s3前i+j个字符
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) ||
                        (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));

            }

        }

        return dp[m][n];
    }
}

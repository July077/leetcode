package offer2;

/**
 * 剑指 Offer II 092. 翻转字符
 * <p>
 * 如果一个由'0' 和 '1'组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * <p>
 * 我们给出一个由字符 '0' 和 '1'组成的字符串 s，我们可以将任何'0' 翻转为'1'或者将'1'翻转为'0'。
 * <p>
 * 返回使 s单调递增的最小翻转次数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/7 下午9:01
 */
public class Q092翻转字符 {

    public int minFlipsMonoIncr(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int[] dp = new int[2];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            dp[1] = 1;
        } else {
            dp[0] = 1;
        }

        for (int i = 1; i < length; i++) {
            dp[1] = Math.min(dp[0], dp[1]) + (chars[i] == '1' ? 0 : 1);
            dp[0] = dp[0] + (chars[i] == '0' ? 0 : 1);
        }

        return Math.min(dp[0], dp[1]);

    }
}

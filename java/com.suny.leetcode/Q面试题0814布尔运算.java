/**
 * 面试题 08.14. 布尔运算
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "1^0|0|1", result = 0
 * <p>
 * 输出: 2
 * 解释:两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * 示例 2:
 * <p>
 * 输入: s = "0&0&0&1^1|0", result = 1
 * <p>
 * 输出: 10
 *
 * @author sunjianrong
 * @date 2021-12-14 12:05
 */
public class Q面试题0814布尔运算 {
    private Integer[][][] memo;

    public int countEval(String s, int result) {
        final int length = s.length();
        memo = new Integer[length][length][2];
        return dfs(0, length - 1, s, result);
    }

    private int dfs(int l, int r, String s, int result) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return (s.charAt(l) - '0') == result ? 1 : 0;
        }

        if (memo[l][r][result] != null) {
            return memo[l][r][result];
        }

        int ans = 0;
        for (int i = l; i <= r; i++) {
            final char c = s.charAt(i);
            if (result == 0) {
                if (c == '&') {
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 0) + dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 1) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 0);
                }
                if (c == '|') {
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 0);
                }
                if (c == '^') {
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 0) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, i);
                }
            } else {
                if (c == '&') {
                    ans += dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 1);
                }
                if (c == '|') {
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 1) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 0) + dfs(l, i - 1, s, 1) + dfs(i + 1, r, s, 1);
                }
                if (c == '^') {
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 1) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 0);
                }
            }
        }
        return memo[l][r][result] = ans;

    }

}

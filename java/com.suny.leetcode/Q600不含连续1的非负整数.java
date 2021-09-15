/**
 * 600. 不含连续1的非负整数
 * <p>
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含连续的1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 5
 * 解释:
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 * 说明: 1 <= n <= 109
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/11 上午10:26
 */
public class Q600不含连续1的非负整数 {

    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0;
        int res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Q600不含连续1的非负整数 q600 = new Q600不含连续1的非负整数();
        System.out.println(q600.findIntegers(6));
    }
}

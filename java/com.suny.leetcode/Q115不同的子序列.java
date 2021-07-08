/**
 * 115. 不同的子序列
 * <p>
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * @author sunjianrong
 * @date 2021-07-08 9:22
 */
public class Q115不同的子序列 {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        s = " " + s;
        t = " " + t;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        // f(i,j) 代表 s中的下标0-i 字符以及  t中下标为 0-i 字符  是否匹配
        int[][] f = new int[n + 1][m + 1];

        // 原字符只有小写字符, 当往两个字符中插入空格后, f[i][0] = 1 是初始化条件
        for (int i = 0; i < n; i++) {
            f[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 包含两种决策

                // 不使用 cs[i] 进行匹配,则有  f[i][j] = f[i-1][j]
                f[i][j] = f[i - 1][j];

                // 使用 cs[i] 进行匹配, 要求 cs[i] = ct[j] , 然后有 f[i][j] += f[i-1][j-1]
                if (cs[i] == ct[j]) {
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }

        return f[n][m];
    }
}

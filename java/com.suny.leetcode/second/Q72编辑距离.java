package second;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * 
 * 示例 1：
 * 
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * 
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Q72编辑距离 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cache = new int[m + 1][n + 1];

        for (int i = 1; i < m; i++) {
            cache[i][0] = i;
        }

        for (int i = 0; i < n; i++) {
            cache[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                } else {
                    cache[i][j] = compare(cache[i][j - 1] + 1, cache[i - 1][j], cache[i - 1][j - 1] + 1);
                }
            }
        }

        return cache[m][n];

    }

    private int compare(int a, int b, int c) {
        int c1 = Math.min(a, b);
        return Math.min(c1, c);
    }

    // public int minDistance(String word1, String word2) {
    // return dp(word1, word2, word1.length() - 1, word2.length() - 1);
    // }

    public int dp(String word1, String word2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            // 相等就什么都不做
            return dp(word1, word2, i - 1, j - 1);
        } else {
            int compare1 = Math.min(dp(word1, word1, i, j - 1) + 1, dp(word1, word2, i - 1, j) + 1);
            return Math.min(compare1, dp(word1, word2, i - 1, j - 1) + 1);
        }
    }
}

/**
 * 132. 分割回文串 II
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 *
 * @author sunjianrong
 * @date 2021/7/13 下午10:29
 */
public class Q132分割回文串II {

    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[len];
        // 2个字符最多分割1次
        // 3个字符最多分割2次

        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            // 如果 left <= right 取等号表示一个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }

        // 1个字符的时候,不用判断,i从1开始
        for (int i = 0; i < len; i++) {
            if (checkPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }

            // 注意保证 s[j+1:i] 至少要有一个字符串
            for (int j = 0; j < i; j++) {
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[len - 1];
    }
}

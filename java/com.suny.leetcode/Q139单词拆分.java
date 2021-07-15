import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-15 12:09
 */
public class Q139单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];

        Arrays.fill(dp, false);

        dp[0] = true;

        for (int i = 0; i < length; i++) {
            if (!dp[i]) {
                continue;
            }

            for (String w : wordDict) {
                if (w.length() + i <= s.length() && s.startsWith(w, i)) {
                    dp[i + w.length()] = true;
                }

            }

        }

        return dp[length];

    }


}

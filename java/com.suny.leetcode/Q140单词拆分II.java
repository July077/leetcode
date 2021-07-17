import java.util.*;

/**
 * 140. 单词拆分 II
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * @author sunjianrong
 * @date 2021/7/17 上午9:16
 */
public class Q140单词拆分II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 放入哈希表中
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        // 动态规划计算是否有解
        //        dp[i] 表示长度为i的s前缀子串可以拆分为 wordDict 中的单词
        // 长度包括0，因此长度为  len+1
        boolean[] dp = new boolean[len + 1];
        // 0需要被后面的状态参考
        dp[0] = true;

        for (int right = 1; right <= len; right++) {
            // 如果单词集合中的单词长度都不长,就从后往前遍历更快
            for (int left = right - 1; left >= 0; left--) {
                // substring 不街区 s[right] dp[left] 的结果不包含 s[left]
                if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    // 得到 dp[right] = true 就不要往下算了
                    break;
                }

            }

        }


        // 第2步 回溯算法搜索所有条件的解
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, wordSet, dp, path, res);
            return res;
        }

        return res;

    }


    private void dfs(String s, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ", path));
        }

        // 可以拆分的左边界从 len-1 依次枚举到 0
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }

        }

    }
}

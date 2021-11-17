import java.util.HashMap;
import java.util.Map;

/**
 * 318. 最大单词长度乘积
 * 给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * @author sunjianrong
 * @date 2021-11-17 9:18
 */
public class Q318最大单词长度乘积 {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int t = 0;
            final int length = word.length();
            for (int i = 0; i < length; i++) {
                int u = word.charAt(i) - 'a';
                t |= (1 << u);
            }
            if (!map.containsKey(t) || map.get(t) < length) {
                map.put(t, length);
            }
        }

        int ans = 0;
        for (Integer i : map.keySet()) {
            for (Integer j : map.keySet()) {
                if ((i & j) == 0) {
                    ans = Math.max(ans, map.get(i) * map.get(j));
                }
            }
        }
        return ans;

    }
}

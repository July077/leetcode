package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 * <p>
 * 给定两个字符串s和p，找到s中所有 p 的变位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/12 下午10:14
 */
public class Q015字符串中的所有变位词 {

    public List<Integer> findAnagrams(String s, String p) {
        char[] need = new char[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }

        // start跟end 分别控制窗口的前端跟后端
        int start = 0;
        int end = 0;
        char[] window = new char[26];
        List<Integer> ans = new ArrayList<>();
        while (end < s.length()) {
            window[s.charAt(end) - 'a']++;
            while (end - start + 1 == p.length()) {
                if (Arrays.equals(window, need)) {
                    ans.add(start);
                }

                window[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }

        return ans;

    }

}

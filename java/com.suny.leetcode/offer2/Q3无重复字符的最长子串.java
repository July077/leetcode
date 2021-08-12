package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/12 下午10:25
 */
public class Q3无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果有重复的了,就取一个同值的下标+1
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // map.get(c) + 1 取的是上一个重复的下标后一个节点
                left = Math.max(left, map.get(c) + 1);

            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;

    }

    public static void main(String[] args) {
        Q3无重复字符的最长子串 q3 = new Q3无重复字符的最长子串();
        System.out.println(q3.lengthOfLongestSubstring("pwwkew"));
    }
}

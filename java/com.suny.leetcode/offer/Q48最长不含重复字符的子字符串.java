package offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/4 下午10:15
 */
public class Q48最长不含重复字符的子字符串 {

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            while (queue.contains(c)) {
                queue.poll();
            }

            queue.add(c);
            res = Math.max(res, queue.size());
        }

        return res;

    }
}

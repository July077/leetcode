package offer2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 032. 有效的变位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同且字符顺序不完全相同，则称s 和 t互为变位词（字母异位词）。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/17 下午10:09
 */
public class Q032有效的变位词 {


    public boolean isAnagram1(String s, String t) {
        if (s.equals(t)) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }


        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
            ints[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(ints).noneMatch(i -> i != 0);
    }


    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars1 = s.toCharArray();
        for (char c : chars1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        // 开始抵消
        char[] chars2 = t.toCharArray();
        for (char c : chars2) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Q032有效的变位词 q32 = new Q032有效的变位词();
        System.out.println(q32.isAnagram("a", "ab"));
    }

}

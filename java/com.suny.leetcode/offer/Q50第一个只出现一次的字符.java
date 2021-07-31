package offer;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/31 下午2:38
 */
public class Q50第一个只出现一次的字符 {


    public char firstUniqChar(String s) {
        int[] targets = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            targets[c - 'a']++;
        }

        for (char c : chars) {
            if (targets[c - 'a'] == 1) {
                return c;
            }
        }

        return ' ';

    }
}

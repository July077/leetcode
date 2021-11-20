/**
 * 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：word = "FlaG"
 * 输出：false
 *
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-15 12:03
 */
public class Q520检测大写字母 {

    public boolean detectCapitalUse(String word) {
        int upper = 0;
        int lower = 0;
        final char[] chars = word.toCharArray();
        for (char c : chars) {
            if (c >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }

        if (upper == chars.length) {
            return true;
        }

        if (lower == chars.length) {
            return true;
        }

        if (upper == 1 && chars[0] < 'a') {
            return true;
        }

        return false;
    }
}

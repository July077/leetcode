package offer2;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * 给定一个非空字符串s，请判断如果最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/13 下午10:58
 */
public class Q019最多删除一个字符得到回文 {

    public boolean validPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return isValid(chars, left + 1, right) || isValid(chars, left, right - 1);
            }
        }
        return true;

    }

    private boolean isValid(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * 680. 验证回文字符串 Ⅱ
 * <p>
 * 给定一个非空字符串s，最多删除一个字符。判断是否能成为回文字符串。
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
 * 解释: 你可以删除c字符。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-06 10:15
 */
public class Q680验证回文字符串Ⅱ {

    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        final char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return match(s, left + 1, right) || match(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }


    private boolean match(String s, int left, int right) {
        if (s.length() == 1) {
            return true;
        }


        final char[] chars = s.toCharArray();
        while (left <= right) {
            final char l = chars[left];
            final char r = chars[right];
            if (l != r) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        final Q680验证回文字符串Ⅱ q680 = new Q680验证回文字符串Ⅱ();
        System.out.println(q680.match("aba", 0, 2));
        System.out.println(q680.match("abba", 0, 3));
    }
}

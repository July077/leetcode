/**
 * 541. 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-20 9:15
 */
public class Q541反转字符串II {
    public String reverseStr(String s, int k) {
        final char[] chars = s.toCharArray();
        final int length = s.length();

        // 每2k个元素为一组进行反转
        for (int i = 0; i < length; i += 2 * k) {
            int left = i;
            // 防止越界
            int right = (i + k - 1 < length) ? i + k - 1 : length - 1;

            while (left <= right) {
                final char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }

        }

        return new String(chars);
    }

}

/**
 * 859. 亲密字符串
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回true；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 *
 * @author sunjianrong
 * @date 2021-11-23 9:24
 */
public class Q859亲密字符串 {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            final int a = s.charAt(i) - 'a';
            final int b = goal.charAt(i) - 'a';

            cnt1[a]++;
            cnt2[b]++;
            if (a != b) {
                sum++;
            }

        }

        boolean isOk = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            if (cnt1[i] > 1) {
                isOk = true;
            }
        }
        return sum == 2 || (sum == 0 && isOk);
    }
}

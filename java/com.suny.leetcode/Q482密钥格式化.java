/**
 * 482. 密钥格式化
 * <p>
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 * <p>
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * <p>
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * 注意，两个额外的破折号需要删掉。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-04 21:05
 */
public class Q482密钥格式化 {

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        final int length = s.length() - 1;
        for (int i = length, cnt = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }

            if (cnt == k && (cnt = 0) >= 0) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
            cnt++;
        }

        return sb.reverse().toString().toUpperCase();
    }
}

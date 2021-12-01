/**
 * 1446. 连续字符
 * 给你一个字符串s，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串的能量。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 * <p>
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 示例 3：
 * <p>
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 * <p>
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * <p>
 *
 * @author sunjianrong
 * @date 2021-12-01 9:18
 */
public class Q1446连续字符 {


    public int maxPower(String s) {
        int res = 1;
        int maxRes = 1;
        final int length = s.length();
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                res++;
                maxRes = Math.max(maxRes, res);
            } else {
                res = 1;
            }
        }
        return maxRes;

    }
}

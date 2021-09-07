/**
 * 1221. 分割平衡字符串
 * <p>
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-07 9:18
 */
public class Q1221分割平衡字符串 {


    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;

        final char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'R') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                res++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        final Q1221分割平衡字符串 q1221 = new Q1221分割平衡字符串();
        System.out.println(q1221.balancedStringSplit(s));
    }
}

/**
 * 91. 解码方法
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunjianrong
 * @date 2021/6/29 下午9:45
 */
public class Q91解码方法 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        if (n == 1) {
            return (s.charAt(0) == '0') ? 0 : 1;
        }

        // 走到这里说明第一位不为0, pre 赋值为1
        int pre = 1;
        int cur = 0;
        // 处理第二位  如果第二位不为0
        if (s.charAt(1) != '0') {
            cur += 1;
        }

        // 处理第二位, 如果第一位+第二位是合法范围数字  则编码数加1
        if (10 <= num(s, 1) && num(s, 1) <= 26) {
            cur += pre;
        }

        // 遍历剩余字符
        for (int i = 2; i < n; ++i) {
            int tmp = 0;

            // 如果当前字符不是0  则至少有一条转移路径,从 pre 得来
            if (s.charAt(i) != '0') {
                tmp += cur;
            }

            // 如果前一个+当前租户的数字在有效范围内
            if (10 <= num(s, i) && num(s, i) <= 26) {
                tmp += pre;
            }

            pre = cur;
            cur = tmp;

        }

        return cur;

    }


    private int num(String s, int index) {
        // 48 是'0'的 ascii 编码,将字符 [0-9] 减去 48 以后得到的具体数字

        int i = s.charAt(index - 1) - 48;
        int j = s.charAt(index) - 48;
        return i * 10 + j;
    }

}

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子numerator 和分母 denominator，以 字符串形式返回小数 。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 如果存在多个答案，只需返回 任意一个 。
 * <p>
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 *
 * @author sunjianrong
 * @date 2021-10-03 16:27
 */
public class Q166分数到小数 {

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }

        StringBuilder sb = new StringBuilder();
        if (a * b < 0) {
            sb.append("-");
        }

        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b).append(".");

        a %= b;

        Map<Long, Integer> map = new HashMap<>();

        while (a != 0) {
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.subSequence(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }

}

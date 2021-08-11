package offer2;

/**
 * 剑指 Offer II 001. 整数除法
 * <p>
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'。
 * <p>
 *
 * <p>
 * 注意：
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,231−1]。本题中，如果除法结果溢出，则返回 231− 1
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/8 下午10:13
 */
public class Q001整数除法 {

    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }

        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        boolean f = false;
        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            f = true;
        }

        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        long ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((x >> i) >= y) {
                ans = ans + ((long) 1 << i);
                x = x - (y << i);
            }
        }

        return f ? (int) ans : (int) (-ans);

    }
}

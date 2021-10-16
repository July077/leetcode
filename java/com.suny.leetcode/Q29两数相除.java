/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数dividend除以除数divisor得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-12 9:21
 */
public class Q29两数相除 {

    public int divide(int dividend, int divisor) {
        // 判断符号
        int sign = (dividend ^ divisor) >= 0 ? 1 : -1;

        // 求绝对值
        long dividendTemp = Math.abs((long) dividend);

        long divisorTemp = Math.abs((long) divisor);
        long res = 0;
        while (dividendTemp >= divisorTemp) {
            long tmp = divisorTemp;
            long times = 1;
            while (dividendTemp >= (tmp << 1)) {
                tmp <<= 1;
                times <<= 1;
            }
            // 被除数减去除数的 times 倍
            dividendTemp -= tmp;

            // 累加 times
            res += times;
        }

        // 添加符号
        res = sign > 0 ? res : -res;
        // 判断是否溢出
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;

    }

}

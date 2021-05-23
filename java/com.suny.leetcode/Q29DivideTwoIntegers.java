/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * @author sunjianrong
 * @date 2021/5/23 下午11:23
 */
public class Q29DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0)
                || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        if (a > b) {
            return 0;
        }

        int ans = div(a, b);
        return sign == -1 ? -ans : ans;

    }

    int div(int a, int b) {
        if (a > b) {
            return 0;
        }

        int count = 1;
        int tb = b;

        //
        while (tb + tb >= a && tb + tb < 0) {
            tb += tb;
            count += count;
        }

        return count + div(a - tb, b);
    }


}

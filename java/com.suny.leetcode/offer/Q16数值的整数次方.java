package offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * @author sunjianrong
 * @date 2021/7/26 下午9:21
 */
public class Q16数值的整数次方 {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            // 最后一位数为1，做乘法
            if ((b & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            b >>= 1;
        }

        return res;

    }
}

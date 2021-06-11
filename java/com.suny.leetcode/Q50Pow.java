/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 * @author sunjianrong
 * @date 2021/6/11 下午11:19
 */
public class Q50Pow {

    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return (x == 1 || x == -1) ? 1 : 0;
        } else if (n == 0) {
            return 1;
        }


        if (n < 0) {
            return myPow(1 / x, -n);
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x, n - 1) * x;
        }

    }
}

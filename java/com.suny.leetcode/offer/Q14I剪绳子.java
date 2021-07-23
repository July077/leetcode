package offer;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * @author sunjianrong
 * @date 2021-07-23 13:45
 */
public class Q14I剪绳子 {

    public int cuttingRope(int n) {
        // 处理几种特殊的情况
        // n=2 的时候，必须分割为2段,则结果为 1x1=1
        // n=3 的时候,至少分割为2段，结果为 2x1 = 2
        // n=4 的时候，至少分割两段,则结果为 2x2 = 4
        if (n < 4) {
            return n - 1;
        }

        int res = 1;
        while (n > 4) {
            res = res * 3;
            n = n - 3;
        }

        return res * n;
    }
}

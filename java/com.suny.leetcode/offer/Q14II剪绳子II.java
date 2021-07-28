package offer;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-23 14:03
 */
public class Q14II剪绳子II {

    int modNum = 1000000007;

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        long res = 1L;

        // 贪心
        while (n > 4) {
            res = res * 3 % modNum;
            n = n - 3;
        }

        return (int) (res * n % modNum);

    }
}

/**
 * 629. K个逆序对数组
 * 给出两个整数n和k，找出所有包含从1到n的数字，且恰好拥有k个逆序对的不同的数组的个数。
 * <p>
 * 逆序对的定义如下：对于数组的第i个和第j个元素，如果满i<j且a[i]>a[j]，则其为一个逆序对；否则不是。
 * <p>
 * 由于答案可能很大，只需要返回 答案 mod 109+ 7 的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释:
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-11 9:34
 */
public class Q629K个逆序对数组 {

    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] f = new int[2][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int cur = i & 1;
                int prev = cur ^ 1;
                f[cur][j] = (j - 1 >= 0 ? f[cur][j - 1] : 0) - (j - i >= 0 ? f[prev][j - i] : 0) + f[prev][j];
                if (f[cur][j] >= mod) {
                    f[cur][j] -= mod;
                } else if (f[cur][j] < 0) {
                    f[cur][j] += mod;
                }

            }

        }
        return f[n & 1][k];
    }
}

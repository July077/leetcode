/**
 * 372. 超级次方
 * 你的任务是计算ab对1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 * <p>
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 * <p>
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * <p>
 *
 * @author sunjianrong
 * @date 2021/12/5 下午10:41
 */
public class Q372超级次方 {
    static final int mod = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i] )% mod);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % mod);
            }
            x = (int) ((long) x * x % mod);
            n /= 2;
        }
        return res;
    }
}

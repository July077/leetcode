/**
 * 326. 3的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-23 21:41
 */
public class Q3263的幂 {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }
}

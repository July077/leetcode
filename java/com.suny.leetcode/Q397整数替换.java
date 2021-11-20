/**
 * 397. 整数替换
 * 给定一个正整数n ，你可以做如下操作：
 * <p>
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-19 9:18
 */
public class Q397整数替换 {

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }

        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }
}

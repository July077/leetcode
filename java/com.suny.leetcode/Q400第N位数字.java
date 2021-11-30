/**
 * 400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第n 位数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * @author sunjianrong
 * @date 2021-11-30 9:34
 */
public class Q400第N位数字 {

    public int findNthDigit(int n) {
        int cur = 1;
        int base = 9;
        while (n > cur * base) {
            n -= cur * base;
            cur++;

            base *= 10;
            if (Integer.MAX_VALUE / base < cur) {
                break;
            }
        }

        n--;
        int num = (int) Math.pow(10, cur - 1) + n / cur;
        int idx = n % cur;
        return num / (int) Math.pow(10, cur - 1 - idx) % 10;
    }
}

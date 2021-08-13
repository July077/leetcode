/**
 * 233. 数字 1 的个数
 * <p>
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：6
 *
 * @author sunjianrong
 * @date 2021-08-13 9:18
 */
public class Q233数字1的个数 {

    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        int hight = n / 10;
        int cur = n % 10;
        int low = 0;

        while (hight != 0 || cur != 0) {
            // 高位 * 低位 为1的个数
            // 对当前位数精心判断，找到真实为1的个数
            if (cur == 0) {
                res += hight * digit;
            } else if (cur == 1) {
                res += hight * digit + low + 1;
            } else {
                res += (hight + 1) * digit;
            }

            // 看看低位有多少种为的方式
            low += cur * digit;
            cur = hight % 10;
            hight /= 10;
            digit *= 10;
        }

        return res;
    }

    public int countDigitOne0(int n) {
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j > 0; j = j / 10) {
                if (j % 10 == 1) {
                    ++cnt;
                }

            }

        }
        return cnt;

    }
}

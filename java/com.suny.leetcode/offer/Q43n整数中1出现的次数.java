package offer;

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-13 10:08
 */
public class Q43n整数中1出现的次数 {

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


}

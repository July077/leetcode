package offer;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/30 下午10:09
 */
public class Q44数字序列中某一位的数字 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;

        // 1
        while (n > count) {
            n = Math.toIntExact(n - count);
            digit += 1;
            start = start * 10;
            count = digit * start * 9;
        }

        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';

    }
}

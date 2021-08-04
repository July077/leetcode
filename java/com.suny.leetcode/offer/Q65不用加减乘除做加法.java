package offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author sunjianrong
 * @date 2021-08-04 12:03
 */
public class Q65不用加减乘除做加法 {

    public int add(int a, int b) {
        while (b != 0) {
            // 保存进位的1
            int c = (a & b) << 1;
            // c已经保存了进位1，俩1不能再相加
            a = a ^ b;
            // 进位部分循环给a
            b = c;
        }

        return a;

    }

}

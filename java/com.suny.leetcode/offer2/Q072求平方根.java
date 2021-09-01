package offer2;

/**
 * 剑指 Offer II 072. 求平方根
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * <p>
 * 正数的平方根有两个，只输出其中的正数平方根。
 * <p>
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: x = 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/31 下午9:12
 */
public class Q072求平方根 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }


        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                // left,mid-1
                right = mid - 1;
            } else {
                // mid,right
                left = mid;
            }
        }

        return left;

    }
}

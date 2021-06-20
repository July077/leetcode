/**
 * 69. x 的平方根
 * 实现int sqrt(int x)函数。
 * <p>
 * 计算并返回x的平方根，其中x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author sunjianrong
 * @date 2021/6/20 下午11:03
 */
public class Q69x的平方根 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 开始二分法
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 避免乘法溢出故使用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left,mid-1]
                right = mid - 1;
            } else {
                // 下一轮是 [mid,right]
                left = mid;
            }
        }

        return left;

    }
}

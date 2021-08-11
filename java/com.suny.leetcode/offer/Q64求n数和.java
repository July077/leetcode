package offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出:6
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/7 下午10:58
 */
public class Q64求n数和 {

    int res;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res = res + n;
        return res;
    }

}

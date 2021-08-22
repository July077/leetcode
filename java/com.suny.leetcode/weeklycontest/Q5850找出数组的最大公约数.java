package weeklycontest;

import java.util.Arrays;

/**
 * 5850. 找出数组的最大公约数
 * <p>
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * <p>
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,9,10]
 * 输出：2
 * 解释：
 * nums 中最小的数是 2
 * nums 中最大的数是 10
 * 2 和 10 的最大公约数是 2
 *
 * @author sunjianrong
 * @date 2021/8/22 上午10:44
 */
public class Q5850找出数组的最大公约数 {

    public int findGCD(int[] nums) {
        // 排序
        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];

        // 寻找公约数
        return gcd(min, max);
    }

    /**
     * 一、求最大公约数：欧几里德算法
     * <p>
     * 欧几里德算法又称辗转相除法，用于计算两个正整数a，b的最大公约数
     * <p>
     * 其计算原理依赖于下面的定理：
     * <p>
     * 定理：两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数。最大公约数缩写为gcd。
     * <p>
     * gcd(a, b) = gcd(b, a mod b)（前提条件是假设a > b 且 r = a mod b, r 不为0）
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        // 小数放b里面
        if (a < b) {
            swap(a, b);
        }

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public void swap(int a, int b) {
        int tmp = b;
        b = a;
        a = b;
    }
}

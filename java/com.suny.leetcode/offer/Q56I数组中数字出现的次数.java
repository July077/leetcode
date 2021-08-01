package offer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/1 下午9:54
 */
public class Q56I数组中数字出现的次数 {

    // 特别难。。。。
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        int y = 0;
        int n = 0;
        int m = 1;

        // 亦或
        for (int num : nums) {
            n ^= num;
        }

        // 循环左移动,计算 m
        while ((n & m) == 0) {
            m <<= 1;
        }

        // 分组
        for (int num : nums) {
            if ((num & m) != 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
        }

        // 返回只出现一次的数字
        return new int[]{x, y};

    }
}

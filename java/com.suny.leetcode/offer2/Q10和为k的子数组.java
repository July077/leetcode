package offer2;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * 给定一个整数数组和一个整数k ，请找到该数组中和为k的连续子数组的个数。
 * <p>
 *
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-11 12:00
 */
public class Q10和为k的子数组 {

    public int subarraySum(int[] nums, int k) {
        int size = nums.length;
        int res = 0;

        for (int left = 0; left < size; left++) {
            int sum = 0;

            for (int right = left; right < size; right++) {
                // 累加左右区间值，相等就加1
                sum = sum + nums[right];
                if (sum == k) {
                    res = res + 1;
                }
            }
        }

        return res;

    }
}

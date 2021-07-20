import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 * <p>
 * 一个数对(a,b)的 数对和等于a + b。最大数对和是一个数对数组中最大的数对和。
 * <p>
 * 比方说，如果我们有数对(1,5)，(2,3)和(4,4)，最大数对和为max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8。
 * 给你一个长度为 偶数n的数组nums，请你将 nums中的元素分成 n / 2个数对，使得：
 * <p>
 * nums中每个元素恰好在 一个数对中，且
 * 最大数对和的值 最小。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-20 9:11
 */
public class Q1877数组中最大数对和的最小值 {


    // 双指针方法
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        // 左指针每次往右移1 ， 右指针每次往左移1，计算两数之和
        int res = -1;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            res = Math.max(res, nums[left++] + nums[right--]);
        }

        return res;
    }
}

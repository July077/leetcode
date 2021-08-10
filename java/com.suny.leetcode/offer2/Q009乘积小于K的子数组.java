package offer2;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 给定一个正整数数组nums和整数 k，请找出该数组内乘积小于k的连续的子数组的个数。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/10 下午10:46
 */
public class Q009乘积小于K的子数组 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int mul = 1;
        int res = 0;

        while (right < nums.length) {
            int num = nums[right];
            right++;
            // 当前元素已经大于等于k，乘下去已经没有意义
            if (num >= k) {
                left = right;
                mul = 1;
                continue;
            }

            mul = mul * num;
            //乘积大于k，左边就开始缩小窗口，直到乘积小于k
            while (mul >= k) {
                mul = mul / nums[left];
                left++;
            }

            if (mul < k) {
                res += (right - left);
            }
        }
        return res;

    }
}

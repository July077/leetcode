package offer2;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-10 11:56
 */
public class Q008和大于等于target的最短子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int size = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                size = Math.min(size, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }

    // 暴力解法
    public int minSubArrayLen0(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        final int length = nums.length;

        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }

            for (int j = i + 1; j < length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }

}

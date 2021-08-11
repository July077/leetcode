package offer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,7,3,6,5,6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/11 下午9:13
 */
public class Q012左右两边子数组的和相等 {


    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();

        int sum = 0;

        // 一个加  一个减  相等的时候就是中点
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (total == sum) {
                return i;
            }
            total = total - nums[i];

        }
        return -1;

    }

    // 前缀和
    public int pivotIndex0(int[] nums) {
        int total = Arrays.stream(nums).sum();

        int sum = 0;

        // 找到中位数
        for (int i = 0; i < nums.length; i++) {
            if ((2 * sum) + nums[i] == total) {
                return i;
            }

            sum += nums[i];
        }


        return -1;

    }


    public static void main(String[] args) {
        int[] ints = new int[]{1, 7, 3, 6, 5, 6};
        Q012左右两边子数组的和相等 q12 = new Q012左右两边子数组的和相等();
        q12.pivotIndex(ints);
    }

}

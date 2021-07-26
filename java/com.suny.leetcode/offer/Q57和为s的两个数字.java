package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]<= 10^6
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/26 上午10:29
 */
public class Q57和为s的两个数字 {

    public int[] twoSum(int[] nums, int target) {
        // 双指针
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int total = nums[left] + nums[right];

            if (total < target) {
                // 比目标数小，左指针往右移动
                left++;
            } else if (total > target) {
                // 比目标数大,右指针往左边移动
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int target = 9;
        Q57和为s的两个数字 q57 = new Q57和为s的两个数字();
        int[] twoSum = q57.twoSum(ints, target);
        Arrays.stream(twoSum).forEach(i -> System.out.println(i));
    }
}

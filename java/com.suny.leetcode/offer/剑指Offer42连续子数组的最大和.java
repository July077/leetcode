package offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 *
 * @author sunjianrong
 * @date 2021/7/17 上午9:50
 */
public class 剑指Offer42连续子数组的最大和 {

    public static void main(String[] args) {
        剑指Offer42连续子数组的最大和 q42 = new 剑指Offer42连续子数组的最大和();
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray0 = q42.maxSubArray0(ints);
        System.out.println("最终答案" + maxSubArray0);
    }

    // 动态规划
    public int maxSubArray0(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            System.out.println("nums[" + i + "] =" + nums[i]);
            res = Math.max(res, nums[i]);
            System.out.println("res =" + "Math.max(" + res + ", nums[" + i + "]) = " + Math.max(res, nums[i]));
        }

        return res;
    }


    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }

            max = Math.max(max, sum);
        }

        return max;

    }
}

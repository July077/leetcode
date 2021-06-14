/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author sunjianrong
 * @date 2021/6/14 下午10:54
 */
public class Q53最大子序和 {

    public int maxSubArray(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n];
       dp[0] = nums[0];


       int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+ nums[i] , nums[i]);
            max = Math.max(max,dp[i]);
        }

        return max;


    }

}

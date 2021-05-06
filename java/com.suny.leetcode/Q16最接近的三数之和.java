import java.util.Arrays;

/**
 * @author sunjianrong
 * @date 2021/5/6 下午10:13
 */
public class Q16最接近的三数之和 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int sumClosest = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(sumClosest);
    }


}

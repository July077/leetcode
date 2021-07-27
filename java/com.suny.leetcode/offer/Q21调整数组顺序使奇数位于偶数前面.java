package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/26 上午11:04
 */
public class Q21调整数组顺序使奇数位于偶数前面 {

    public int[] exchange0(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }

        return nums;
    }


    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];

            // 是奇数
            if ((leftNum & 1) == 1) {
                left++;
                continue;
            }

            // 是偶数
            if ((rightNum & 1) == 0) {
                right--;
                continue;
            }

            // 交换两个数
            swap(nums, left++, right--);

        }

        return nums;
    }


    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private boolean isOdd(int num) {
        return (num & 1) != 0;
    }


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] params = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        Arrays.stream(params).forEach(i -> sb.append(i).append(","));
        System.out.println("参数:" + sb.toString());
        Q21调整数组顺序使奇数位于偶数前面 q21 = new Q21调整数组顺序使奇数位于偶数前面();

        StringBuilder builder = new StringBuilder();
        int[] exchange = q21.exchange(params);
        Arrays.stream(exchange).forEach(i -> builder.append(i).append(","));
        System.out.println("结果:" + builder.toString());

    }

}

/**
 * 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *
 * @author sunjianrong
 * @date 2021-12-03 11:57
 */
public class Q1005K次取反后最大化的数组和 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] number = new int[201];
        for (int num : nums) {
            number[num + 100]++;
        }

        int i = 0;
        while (k > 0) {
            while (number[i] == 0) {
                i++;
            }
            number[i]--;
            number[200 - i]++;
            if (i > 100) {
                i = 200 - i;
            }
            k--;
        }

        int sum = 0;
        for (int j = 0; j < number.length; j++) {
            sum += (j - 100) * number[j];
        }
        return sum;
    }

}

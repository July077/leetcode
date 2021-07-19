import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * <p>
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * <p>
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 *
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-19 9:15
 */
public class Q1838最高频元素的频数 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = 1;
        int j = 0;
        long a = 0;
        for (int i = 1; i < nums.length; i++) {
            //  计算区间值
            a += (nums[i] - nums[i - 1]) * (i - j);

            // 超过目标
            while (a > k) {
                // 减去区间最左侧的值跟最后一个值的差距
                a -= nums[i] - nums[j];
                j++;
            }
            ans = Math.max(i - j + 1, ans);
        }

        return ans;

    }
}

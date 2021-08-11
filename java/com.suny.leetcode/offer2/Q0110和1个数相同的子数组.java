package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-11 12:12
 */
public class Q0110和1个数相同的子数组 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int ans = 0;
        int sum = 0;

        map.put(0, 0);

        for (int i = 0; i < length; i++) {
            sum += 2 * nums[i] - 1;
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i + 1 - map.get(sum));
            } else {
                map.put(sum, i + 1);
            }
        }

        return ans;

    }
}

package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @author sunjianrong
 * @date 2021/7/19 下午8:45
 */
public class Q03数组中重复的数字 {

    // 原地交换
    public int findRepeatNumber0(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }

            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }

            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;

        }
        return -1;
    }

    // 哈希表
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return -1;

    }
}

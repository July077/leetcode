package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/29 下午9:46
 */
public class Q39数组中出现次数超过一半的数字 {

    public int majorityElement1(int[] nums) {
        int x = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }

            if (num == x) {
                votes = votes + 1;
            } else {
                votes = votes - 1;
            }
        }

        //验证是否为众数
        int count = 0;
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }

        return count > nums.length / 2 ? x : 0;

    }

    public int majorityElement0(int[] nums) {
        // 排序后必在中间位置
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement(int[] nums) {
        int middle = (nums.length) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            int v = map.getOrDefault(i, 0) + 1;
            if (v > middle) {
                return i;
            }

            map.put(i, v);
        }

        return -1;
    }

}

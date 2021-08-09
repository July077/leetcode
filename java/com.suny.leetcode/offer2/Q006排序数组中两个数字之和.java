package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * <p>
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0开始计数 ，所以答案数组应当满足 0<= answer[0] < answer[1] <numbers.length。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/9 下午9:41
 */
public class Q006排序数组中两个数字之和 {

    public int[] twoSum(int[] numbers, int target) {
        // 双指针 一头一尾开始逼近求和
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] < target) {
                ++i;
            } else if (numbers[i] + numbers[j] > target) {
                --j;
            } else {
                return new int[]{i, j};
            }

        }
        return new int[]{-1, -1};

    }

    // 错误的尝试
    public int[] twoSum0(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (map.containsKey(target - key)) {
                return new int[]{entry.getValue(), map.get(target - key)};
            }
        }

        return new int[]{-1, -1};

    }
}

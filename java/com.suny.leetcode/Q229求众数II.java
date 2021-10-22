import java.util.*;

/**
 * 229. 求众数 II
 * 给定一个大小为n的整数数组，找出其中所有出现超过⌊ n/3 ⌋次的元素。
 * <p>
 *
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-22 9:24
 */
public class Q229求众数II {
    public List<Integer> majorityElement(int[] nums) {
        final int threshold = nums.length / 3;

        Set<Integer> res = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            final Integer orDefault = map.getOrDefault(num, 0);
            final int newValue = orDefault + 1;
            map.put(num, newValue);
            if (newValue > threshold) {
                res.add(num);
            }
        }
        return new ArrayList<>(res);

    }

}

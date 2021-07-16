package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunjianrong
 * @date 2021-07-16 9:07
 */
public class 剑指Offer53在排序数组中查找数字I {

    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            final Integer value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }

        return map.get(target) == null ? 0 : map.get(target);

    }

}

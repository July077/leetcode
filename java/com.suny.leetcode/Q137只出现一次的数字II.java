import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * <p>
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * @author sunjianrong
 * @date 2021-07-14 21:18
 */
public class Q137只出现一次的数字II {

    public int singleNumber(int[] nums) {
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}

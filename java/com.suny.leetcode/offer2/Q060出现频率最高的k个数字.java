package offer2;

import java.util.*;

/**
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 * 给定一个整数数组 nums 和一个整数 k，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/27 下午9:44
 */
public class Q060出现频率最高的k个数字 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        // 队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }


        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

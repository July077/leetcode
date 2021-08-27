package offer2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 061. 和最小的 k 个数对
 * 给定两个以升序排列的整数数组 nums1 和 nums2,以及一个整数 k。
 * <p>
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 * <p>
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/27 下午10:24
 */
public class Q061和最小的k个数对 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> o2.get(0) + o2.get(1) - (o1.get(0) + o1.get(1)));

        // 遍历所有可能的集合
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (queue.size() != k || (nums1[i] + nums2[j]) <= (queue.peek().get(0) + queue.peek().get(1))) {
                    if (queue.size() == k) {
                        queue.poll();
                    }

                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    queue.add(list);
                }
            }
        }

        // 弹出元素
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res.add(0, queue.poll());
        }

        return res;

    }
}

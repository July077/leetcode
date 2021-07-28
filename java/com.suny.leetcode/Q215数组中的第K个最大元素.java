import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-28 12:23
 */
public class Q215数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }

        final PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)-> o1-o2);
        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 1; i < k; i++) {
            queue.poll();
        }

        if (queue.size() == 0) {
            return -1;
        }
        return queue.poll();
    }
}

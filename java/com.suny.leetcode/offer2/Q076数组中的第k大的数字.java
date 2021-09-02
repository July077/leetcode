package offer2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 076. 数组中的第 k 大的数字
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
 * @date 2021-09-02 11:54
 */
public class Q076数组中的第k大的数字 {


    public int findKthLargest(int[] nums, int k) {
        final int length = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < length; i++) {
            final Integer peek = queue.peek();
            if (nums[i] > peek) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        return queue.peek();
    }


    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}

package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-28 12:08
 */
public class Q40最小的k个数 {

    // 优先队列解法
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }


        final PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i : arr) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (queue.peek() != null && i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }

        return new ArrayList<>(queue).stream().mapToInt(Integer::intValue).toArray();

    }


}

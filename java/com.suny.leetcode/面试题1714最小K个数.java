import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 * <p>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-03 9:42
 */
public class 面试题1714最小K个数 {

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        // 比较
        for (int i = k; i < arr.length; ++i) {
            final Integer peek = queue.peek();
            if (peek == null) {
                continue;
            }
            if (peek > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = queue.poll();
        }

        return ints;

    }


    public int[] smallestK1(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }


        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}

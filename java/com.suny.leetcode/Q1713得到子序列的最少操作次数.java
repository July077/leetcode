import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1713. 得到子序列的最少操作次数
 * <p>
 * 给你一个数组target，包含若干 互不相同的整数，以及另一个整数数组arr，arr可能 包含重复元素。
 * <p>
 * 每一次操作中，你可以在 arr的任意位置插入任一整数。比方说，如果arr = [1,4,1,2]，那么你可以在中间添加 3得到[1,4,3,1,2]。你可以在数组最开始或最后面添加整数。
 * <p>
 * 请你返回 最少操作次数，使得target成为arr的一个子序列。
 * <p>
 * 一个数组的 子序列指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4]是[4,2,3,7,2,1,4]的子序列（加粗元素），但[2,4,2]不是子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [5,1,3], arr = [9,4,2,3,4]
 * 输出：2
 * 解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
 * 示例 2：
 * <p>
 * 输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
 * 输出：3
 *
 * @author sunjianrong
 * @date 2021/7/26 上午8:59
 */
public class Q1713得到子序列的最少操作次数 {

    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        List<Integer> stack = new ArrayList<>();
        for (int a : arr) {
            Integer targetIndex = map.get(a);
            if (targetIndex == null) {
                continue;
            }

            int left = 0;
            int right = stack.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (stack.get(mid) >= targetIndex) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == stack.size()) {
                stack.add(targetIndex);
            } else {
                stack.set(left, targetIndex);
            }
        }

        return target.length - stack.size();

    }

}

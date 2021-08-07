/**
 * 457. 环形数组是否存在循环
 * 存在一个不含 0 的 环形 数组nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * <p>
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * <p>
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/7 下午10:18
 */
public class Q457环形数组是否存在循环 {
    int[] nums;
    int n;


    public boolean circularArrayLoop(int[] nums) {
        this.n = nums.length;
        this.nums = nums;

        // 开始可能从负数开始
        for (int i = 0; i < n; ++i) {
            int slow = i;
            int fast = next(i);
            // 检查同向
            while (nums[fast] * nums[slow] > 0 && nums[next(fast)] * nums[slow] > 0) {
                if (fast == slow) {
                    if (slow == next(slow)) {
                        // 存在长度为1的同向环
                        break;
                    } else {
                        return true;
                    }
                }

                // 指针移动
                fast = next(next(fast));
                slow = next(slow);
            }
        }

        return false;
    }


    private int next(int i) {
        return ((i + nums[i]) % n + n) % n;
    }
}

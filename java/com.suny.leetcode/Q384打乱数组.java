import java.util.Random;

/**
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * <p>
 * 实现 Solution class:
 * <p>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-22 9:22
 */
public class Q384打乱数组 {

    private int[] origin;
    private int n;
    private Random random = new Random();

    public Q384打乱数组(int[] nums) {
        origin = nums;
        n = nums.length;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        final int[] clone = origin.clone();
        for (int i = 0; i < n; i++) {
            swap(clone, i, i + random.nextInt(n - i));
        }
        return clone;
    }

    private int[] swap(int[] res, int i, int j) {
        int tmp = res[i];
        res[i] = res[j];
        res[j] = tmp;
        return res;
    }
}

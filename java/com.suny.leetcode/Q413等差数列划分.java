import java.util.ArrayList;
import java.util.List;

/**
 * 413. 等差数列划分
 * <p>
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-10 9:11
 */
public class Q413等差数列划分 {
    List<int[]> res = new ArrayList<>();

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int ans = 0;
        int slow = 0;
        int fast = 1;

        while (fast < nums.length - 1) {
            if (fast - slow < 2) {
                if (nums[fast + 1] - nums[fast] == nums[slow + 1] - nums[slow]) {
                    ++fast;
                } else {
                    ++slow;
                }

            } else {
                if (nums[fast + 1] - nums[fast] == nums[slow + 1] - nums[slow]) {
                    ++fast;
                } else {
                    ans += settlement(slow, fast);
                    slow = fast;
                }

            }
        }

        if (fast - slow >= 2) {
            ans += settlement(slow, fast);
        }


        return ans;
    }


    // 计算最后一个窗口
    private int settlement(int slow, int fast) {
        return (fast - slow) * (fast - slow - 1) / 2;
    }
}

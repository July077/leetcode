package weeklycontest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5863. 统计特殊四元组
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * <p>
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 *
 * @author sunjianrong
 * @date 2021/9/5 上午11:00
 */
public class Q5863统计特殊四元组 {


    public int countQuadruplets1(int[] nums) {
        int length = nums.length;
        int res = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    for (int l = k + 1; l < length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            res++;
                        }
                    }
                }
            }

        }

        return res;
    }


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public int countQuadruplets(int[] nums) {
        if (nums == null || nums.length < 4) {
            return 0;
        }

        Arrays.sort(nums);

        dfs(nums, 0);
        return res.size();
    }

    private void dfs(int[] nums, int begin) {
        if (path.size() == 4) {
        }
    }


}

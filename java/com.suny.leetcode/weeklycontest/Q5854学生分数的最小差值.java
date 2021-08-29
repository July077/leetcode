package weeklycontest;

import java.util.*;

/**
 * 5854. 学生分数的最小差值
 * <p>
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * <p>
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * <p>
 * 返回可能的 最小差值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [90], k = 1
 * 输出：0
 * 解释：选出 1 名学生的分数，仅有 1 种方法：
 * - [90] 最高分和最低分之间的差值是 90 - 90 = 0
 * 可能的最小差值是 0
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,1,7], k = 2
 * 输出：2
 * 解释：选出 2 名学生的分数，有 6 种方法：
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
 * - [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
 * 可能的最小差值是 2
 *
 * @author sunjianrong
 * @date 2021/8/29 上午10:41
 */
public class Q5854学生分数的最小差值 {

//    private int res = 0;

    public int minimumDifference(int[] nums, int k) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i + k - 1] - nums[i] < res) {
                res = nums[i + k - 1] - nums[i];
            }

        }
        return res;
    }

    private void dfs(int[] nums, int k, Deque<Integer> path, int cunrrIndex, List<List<Integer>> list) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = cunrrIndex; i < nums.length; i++) {

            // 递归
            path.addLast(nums[i]);
            dfs(nums, k, path, i + 1, list);

            // 复位
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        Q5854学生分数的最小差值 q5854 = new Q5854学生分数的最小差值();
        q5854.minimumDifference(ints, 3);
    }

}

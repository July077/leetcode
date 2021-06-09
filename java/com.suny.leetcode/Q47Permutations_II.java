import java.util.*;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @author sunjianrong
 * @date 2021/6/9 下午9:16
 */
public class Q47Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;

        if (length == 0) {
            return res;
        }

        Arrays.sort(nums);

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];

        dfs(nums, length, 0, used, path, res);
        return res;
    }


    private void dfs(int[] nums, int length, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }

            // 开始剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, length, depth + 1, used, path, res);

            // 回溯,把条件切换回原始状态
            used[i] = false;
            path.removeLast();
        }
    }
}

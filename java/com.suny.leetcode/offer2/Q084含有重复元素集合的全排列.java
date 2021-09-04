package offer2;

import java.util.*;

/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 * <p>
 * 给定一个可包含重复数字的整数集合nums ，按任意顺序 返回它所有不重复的全排列。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/4 下午10:12
 */
public class Q084含有重复元素集合的全排列 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return res;
        }
        if (nums.length == 1) {
            res.add(Collections.singletonList(nums[0]));
            return res;
        }

        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }


    private void dfs(int[] nums, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);

            dfs(nums, depth + 1);
            used[i] = false;
            path.removeLast();
        }

    }
}

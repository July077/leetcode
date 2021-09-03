package offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 079. 所有子集
 * <p>
 * <p>
 * 给定一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-03 11:04
 */
public class Q079所有子集 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return res;
        }
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));

        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        final int[] ints = {1, 2, 3};
        final Q079所有子集 q079 = new Q079所有子集();
        System.out.println(q079.subsets(ints));
    }
}

package offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * <p>
 * <p>
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * <p>
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-03 12:13
 */
public class Q081允许重复选择元素的组合 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }

    private void dfs(int[] candidates, int begin, int target) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = begin; i <= candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i]);
            path.removeLast();
        }
    }
}

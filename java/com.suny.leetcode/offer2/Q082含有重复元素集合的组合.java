package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * <p>
 * 给定一个可能有重复数字的整数数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/4 下午9:47
 */
public class Q082含有重复元素集合的组合 {

    private List<List<Integer>> res = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }

}

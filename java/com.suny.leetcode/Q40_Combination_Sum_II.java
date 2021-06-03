import java.util.*;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * @author sunjianrong
 * @date 2021/6/3 下午8:20
 */
public class Q40_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || target < 0) {
            return res;
        }

        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, candidates, target, 0, path);

        return res;
    }


    private void dfs(List<List<Integer>> res, int[] candidates, int target, int begin, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = begin; i < candidates.length; i++) {
            int c = candidates[i];
            if (target - c < 0) {
                break;
            }

            // 这一题前后相等就不可以复用
            if (i > begin && c == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            dfs(res, candidates, target - c, i + 1, path);

            path.removeLast();

        }


    }

}

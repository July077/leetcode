import java.util.*;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * @author sunjianrong
 * @date 2021/6/2 下午11:13
 */
public class Q39CombinationSum {

    public static void main(String[] args) {
        Q39CombinationSum solution = new Q39CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int length = candidates.length;
        if (length == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();

        // 提前排序
        Arrays.sort(candidates);
        dfs(candidates, 0, length, target, path, res);
        return res;

    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param length     冗余变量
     * @param target     每减去一个元素，目标值就会变小
     * @param path       从根节点到叶子节点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int length, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 位负数和0的时候不再产生新的孩子节点
//        if (target < 0) {
//            return;
//        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // begin 开始搜索的寓意
        for (int i = begin; i < length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));


            // 每一个元素都可以重复使用,所以下一轮的搜索起点依然是i
            dfs(candidates, i, length, target - candidates[i], path, res);

            System.out.println("递归之后 => " + path);

            // 重置状态
            path.removeLast();
        }

    }

}

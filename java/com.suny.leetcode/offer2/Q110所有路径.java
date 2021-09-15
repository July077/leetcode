package offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 110. 所有路径
 * <p>
 * 给定一个有n个节点的有向无环图，用二维数组graph表示，请找到所有从0到n-1的路径并输出（不要求按顺序）。
 * <p>
 * graph的第 i 个数组中的单元都表示有向图中 i号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/14 下午2:14
 */
public class Q110所有路径 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), graph, 0, graph.length);
        return res;
    }


    private void dfs(List<List<Integer>> resultList, List<Integer> result, int[][] graph, int i, int n) {
        // 终止条件
        if (i == n - 1) {
            result.add(i);
            resultList.add(new ArrayList<>(result));
            result.remove(result.size() - 1);
            return;
        }

        result.add(i);
        for (int i1 : graph[i]) {
            dfs(resultList, result, graph, i1, n);
        }

        result.remove(result.size() - 1);
    }
}

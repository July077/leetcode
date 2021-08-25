import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * <p>
 * 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * <p>
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-25 9:34
 */
public class Q797所有可能的路径 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, graph, new LinkedList<>());
        return res;
    }

    private void dfs(int visited, int[][] graph, LinkedList<Integer> list) {
        list.add(visited);

        if (visited == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i : graph[visited]) {
            dfs(i, graph, list);
            list.removeLast();
        }

    }
}

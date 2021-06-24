import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author sunjianrong
 * @date 2021/6/23 下午10:45
 */
public class Q77组合 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        // 从1开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;

    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 终止条件  path 的长度等于k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向变量添加一个数
            path.addLast(i);
            // 下一轮搜索
            System.out.println("递归之前 => " + path);

            dfs(n, k, i + 1, path, res);

            // dfs有回头的过程,因此递归前做了什么，递归后得做相同的操作
            path.removeLast();

            System.out.println("递归之后 => " + path);
        }

    }

    public static void main(String[] args) {
        Q77组合 q77 = new Q77组合();
        List<List<Integer>> combine = q77.combine(5, 3);
        System.out.println(combine);
    }
}

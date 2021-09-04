package offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-03 11:16
 */
public class Q080含有k个元素的组合 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    /**
     * @param n 范围数  1-n
     * @param k 指定元素集合个数
     * @return 组合
     */
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);

        return res;
    }

    private void dfs(int n, int k, int begin) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        //
        // [[2,4],
        //  [3,4],
        //  [2,3],
        //  [1,2],
        //  [1,3],
        //  [1,4]];
        final Q080含有k个元素的组合 q080 = new Q080含有k个元素的组合();
        System.out.println(q080.combine(4, 2));
    }
}

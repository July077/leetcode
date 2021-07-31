import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 987. 二叉树的垂序遍历
 * <p>
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于(row, col)的每个结点而言，其左右子结点分别位于(row + 1, col - 1)和(row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/31 上午11:03
 */
public class Q987二叉树的垂序遍历 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        nodes.sort((tuple1, tuple2) -> {
            if (tuple1[0] != tuple2[0]) {
                return tuple1[0] - tuple2[0];
            } else if (tuple1[1] != tuple2[1]) {
                return tuple1[1] - tuple2[1];
            } else {
                return tuple1[2] - tuple2[2];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            int col = node[0];
            int row = node[1];
            int value = node[2];
            if (col != lastcol) {
                lastcol = col;
                res.add(new ArrayList<>());
                size++;
            }
            res.get(size - 1).add(value);
        }

        return res;


    }

    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }

        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}

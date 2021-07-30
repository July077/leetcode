package offer;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 *
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-30 12:06
 */
public class Q32II从上到下打印二叉树II {

    List<List<Integer>> r;

    public List<List<Integer>> levelOrder0(TreeNode root) {
        r = new ArrayList<>();
        dfs(0, root);
        return r;
    }

    private void dfs(int depth, TreeNode node) {
        if (node == null) {
            return;
        }

        if (r.size() == depth) {
            r.add(new ArrayList<>());
        }

        r.get(depth).add(node.val);
        dfs(depth + 1, node.left);
        dfs(depth + 1, node.right);

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            res.add(list);
        }

        return res;
    }

}

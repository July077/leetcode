package offer2;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 *
 * @author sunjianrong
 * @date 2021/8/22 下午8:45
 */
public class Q045二叉树最底层最左边的值 {


    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return bfs(root);
    }

    private int bfs(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();


                if (i == 0) {
                    res = poll.val;
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }

            while (size > 0) {


                size--;
            }
        }

        return res;

    }
}

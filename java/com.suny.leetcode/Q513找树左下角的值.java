import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 *
 * @author sunjianrong
 * @date 2021-11-19 11:56
 */
public class Q513找树左下角的值 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode poll = queue.poll();
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
        }
        return res;
    }


}

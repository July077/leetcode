package offer2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 044. 二叉树每层的最大值
 * 给定一棵二叉树的根节点root ，请找出该二叉树中每一层的最大值。
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/22 下午8:19
 */
public class Q044二叉树每层的最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        bfs(res, root);
        return res;
    }

    private void bfs(List<Integer> res, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            while (size > 0) {
                TreeNode poll = queue.poll();
                max = Math.max(max, poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }

                size--;
            }

            res.add(max);

        }

    }
}

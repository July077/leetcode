package offer;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * <p>
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/28 下午10:03
 */
public class Q55I二叉树的深度 {

    // bfs解法
    public int maxDepth0(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

//        List<TreeNode> tmp;

        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        if (maxLeftDepth > maxRightDepth) {
            return maxLeftDepth + 1;
        } else {
            return maxRightDepth + 1;
        }

    }
}

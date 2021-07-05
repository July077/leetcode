import common.TreeNode;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层序遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * @author sunjianrong
 * @date 2021/7/5 下午9:02
 */
public class Q107二叉树的层序遍历II {
    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            while (size > 0) {
                TreeNode treeNode = queue.peekFirst();
                list.add(queue.pollFirst().val);

                if (treeNode.left != null) {
                    queue.offerLast(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offerLast(treeNode.right);
                }
                size--;
            }

            res.add(list);

        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            result.add(res.get(i));
        }


        return result;

    }
}

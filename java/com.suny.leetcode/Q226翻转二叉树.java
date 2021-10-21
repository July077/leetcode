import common.TreeNode;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-21 11:56
 */
public class Q226翻转二叉树 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final TreeNode right = root.right;
        root.right = root.left;
        root.left = right;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            final TreeNode poll = list.poll();

            final TreeNode right = poll.right;
            poll.right = poll.left;
            poll.left = right;

            if (poll.left != null) {
                list.add(poll.left);
            }

            if (poll.right != null) {
                list.add(poll.right);
            }
        }
        return root;
    }

}

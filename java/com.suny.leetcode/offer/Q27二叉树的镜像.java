package offer;

import common.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * /  \
 * 2   7
 * / \  / \
 * 1  3 6  9
 * 镜像输出：
 * <p>
 * 4
 * /  \
 * 7   2
 * / \  / \
 * 9  6 3 1
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/24 下午11:26
 */
public class Q27二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);

        root.left = left;
        root.right = right;
        return root;

    }

}

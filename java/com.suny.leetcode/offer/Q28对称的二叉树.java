package offer;

import common.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2  2
 * / \ / \
 * 3 4 4 3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2  2
 * \  \
 * 3  3
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * @author sunjianrong
 * @date 2021/7/25 上午10:29
 */
public class Q28对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return recur(root.left, root.right);
    }


    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        // 左节点左边跟右节点的右边对比       左节点的右边跟右节点的左边对比
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

}

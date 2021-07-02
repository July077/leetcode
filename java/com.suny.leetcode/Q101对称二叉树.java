import common.TreeNode;

/**
 * 101. 对称二叉树
 * <p>
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * @author sunjianrong
 * @date 2021-07-02 9:28
 */
public class Q101对称二叉树 {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }


        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }


}

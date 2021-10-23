import common.TreeNode;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-22 12:05
 */
public class Q404左叶子之和 {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }


        dfs(root.left);
        dfs(root.right);


    }
}

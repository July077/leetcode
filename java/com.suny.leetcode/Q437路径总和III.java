import common.TreeNode;

/**
 * 437. 路径总和 III
 * <p>
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-28 18:19
 */
public class Q437路径总和III {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return getPath(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int getPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }

        res += getPath(root.right, sum - root.val) + getPath(root.left, sum - root.val);
        return res;
    }
}

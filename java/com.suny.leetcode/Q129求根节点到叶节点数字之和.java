import common.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 *
 * @author sunjianrong
 * @date 2021-07-12 12:08
 */
public class Q129求根节点到叶节点数字之和 {

    public int sumNumbers(TreeNode root) {
        final int helper = helper(root, 0);
        return helper;
    }

    private int helper(TreeNode treeNode, int i) {
        if (treeNode == null) {
            return 0;
        }

        int tmp = i * 10 + treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            return tmp;
        }

        return helper(treeNode.left, tmp) + helper(treeNode.right, tmp);

    }
}

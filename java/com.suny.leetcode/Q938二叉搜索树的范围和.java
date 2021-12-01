import common.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * @author sunjianrong
 * @date 2021-12-01 12:00
 */
public class Q938二叉搜索树的范围和 {
    private int total;

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode treeNode, int low, int high) {
        if (treeNode == null) {
            return 0;
        }

        final int val = treeNode.val;

        if (val < low) {
            return dfs(treeNode.right, low, high);
        }

        if (val > high) {
            return dfs(treeNode.left, low, high);
        }

        return val + dfs(treeNode.right, low, high) + dfs(treeNode.left, low, high);
    }

}

import common.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * @author sunjianrong
 * @date 2021-11-22 12:03
 */
public class Q530二叉搜索树的最小绝对差 {

    private TreeNode pre;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }


        dfs(treeNode.left);
        if (pre != null) {
            result = Math.min(result, treeNode.val - pre.val);
        }
        pre = treeNode;

        dfs(treeNode.right);
    }
}

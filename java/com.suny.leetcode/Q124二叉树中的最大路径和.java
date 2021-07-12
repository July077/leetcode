import common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * @author sunjianrong
 * @date 2021/7/11 上午10:36
 */
public class Q124二叉树中的最大路径和 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return max;
    }


    public int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        // 计算左边分支最大值,如果为负数就直接不选择
        int leftMax = Math.max(0, dfs(treeNode.left));

        // 计算右边分支最大值,右边分支为负数就直接不选择
        int rightMax = Math.max(0, dfs(treeNode.right));

        // left > root > right 作为路径跟已经计算过的历史最大值做比较
        max = Math.max(max, treeNode.val + leftMax + rightMax);

        return treeNode.val + Math.max(leftMax, rightMax);
    }
}

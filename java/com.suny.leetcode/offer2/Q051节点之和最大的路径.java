package offer2;

import common.TreeNode;

/**
 * 剑指 Offer II 051. 节点之和最大的路径
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * @author sunjianrong
 * @date 2021/8/24 下午8:52
 */
public class Q051节点之和最大的路径 {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        // 计算左右节点
        int left = Math.max(0, dfs(treeNode.left));
        int right = Math.max(0, dfs(treeNode.right));

        // 更新最大值
        result = Math.max(result, left + treeNode.val + right);

        // 计算能为父节点贡献的最大值
        return treeNode.val + Math.max(left, right);
    }

}

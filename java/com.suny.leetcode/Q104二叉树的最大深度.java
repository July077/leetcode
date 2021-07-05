import common.TreeNode;

/**
 * 104. 二叉树的最大深度
 * <p>
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 * @author sunjianrong
 * @date 2021-07-05 9:14
 */
public class Q104二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }


        final int maxDepth1 = maxDepth(root.left);
        final int maxDepth2 = maxDepth(root.right);

        return Math.max(maxDepth1, maxDepth2) + 1;
    }
}

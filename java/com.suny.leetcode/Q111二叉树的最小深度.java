import common.TreeNode;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author sunjianrong
 * @date 2021/7/6 下午10:05
 */
public class Q111二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 到达叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 如果左右孩子其中一个为空就返回最大的
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 这种情况则说明左右节点必然有一个为0,可以直接返回 m1+m2+1
        if (root.left == null || root.right == null) {
            return leftDepth + rightDepth + 1;
        }

        // 最后一种情况,左右孩子都不为空,直接返回最小深度+1

        return Math.min(leftDepth, rightDepth) + 1;
    }

}

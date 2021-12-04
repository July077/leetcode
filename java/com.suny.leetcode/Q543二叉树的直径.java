import common.TreeNode;

/**
 * 543. 二叉树的直径
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 *
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-24 12:06
 */
public class Q543二叉树的直径 {


    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return res;
    }


    private int getDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        final int left = getDepth(treeNode.left);
        final int right = getDepth(treeNode.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

}

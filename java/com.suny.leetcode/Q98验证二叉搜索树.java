import common.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author sunjianrong
 * @date 2021/7/1 下午10:02
 */
public class Q98验证二叉搜索树 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        //左子树递归
        if (!isValidBST(root.left)) {
            return false;
        }

        // 中序遍历必然是递增的,后一个节点的值大于前一个节点的值
        if (root.val <= pre) {
            return false;
        }

        pre = root.val;

        // 右子树判断
        return isValidBST(root.right);

    }
}

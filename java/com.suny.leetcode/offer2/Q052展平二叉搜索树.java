package offer2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/24 下午9:16
 */
public class Q052展平二叉搜索树 {

    private List<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);

        TreeNode dummy = new TreeNode(-1);
        TreeNode curr = dummy;

        for (TreeNode treeNode : list) {
            curr.right = treeNode;
            treeNode.left = null;
            curr = treeNode;
        }

        return dummy.right;
    }


    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        dfs(treeNode.left);
        list.add(treeNode);
        dfs(treeNode.right);
    }
}

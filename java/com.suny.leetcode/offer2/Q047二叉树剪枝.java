package offer2;

import common.TreeNode;

/**
 * 剑指 Offer II 047. 二叉树剪枝
 * 给定一个二叉树 根节点root，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * <p>
 * 节点 node 的子树为node 本身，以及所有 node的后代。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-23 11:57
 */
public class Q047二叉树剪枝 {

    public TreeNode pruneTree(TreeNode root) {
        return dfs(root) ? root : null;
    }

    private boolean dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }

        if (!dfs(treeNode.left)) {
            treeNode.left = null;
        }

        if (!dfs(treeNode.right)) {
            treeNode.right = null;
        }

        return treeNode.val == 1 || treeNode.left != null || treeNode.right != null;
    }
}

import common.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-09 12:16
 */
public class Q222完全二叉树的节点个数 {


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }

    }

    private int getDepth(TreeNode treeNode) {
        int depth = 0;
        while (treeNode != null) {
            treeNode = treeNode.left;
            depth++;
        }
        return depth;
    }


    private int res = 0;

    public int countNodes1(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        res = dfs(node.left) + dfs(node.right) + 1;
        return res;
    }
}

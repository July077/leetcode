import common.TreeNode;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第d层追加一行值为v的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为v的左子树和右子树。
 * <p>
 * 将N 原先的左子树，连接为新节点v 的左子树；将N 原先的右子树，连接为新节点v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * 输出:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 *
 * @author sunjianrong
 * @date 2021-12-13 12:02
 */
public class Q623在二叉树中增加一行 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            final TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        preOrder(root, 1, depth, val);
        return root;
    }


    private void preOrder(TreeNode root, int hight, int depth, int val) {
        if (root == null) {
            return;
        }

        if (hight == depth - 1) {
            TreeNode tmp = root.left;
            root.left = new TreeNode(val);
            root.left.left = tmp;
            tmp = root.right;
            root.right = new TreeNode(val);
            root.right.right = tmp;
        }

        preOrder(root.left, hight + 1, depth, val);
        preOrder(root.right, hight + 1, depth, val);

    }

}

import common.TreeNode;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author sunjianrong
 * @date 2021-07-01 9:16
 */
public class Q100相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 同时为空则相等
        if (p == null && q == null) {
            return true;
        }

        // 有一个为空就不同
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(q.left, q.left) && isSameTree(q.right, p.right);


    }

    public static void main(String[] args) {
        final TreeNode leftTreeNode = new TreeNode(1);
        leftTreeNode.left = new TreeNode(2);
        leftTreeNode.right = new TreeNode(3);

        final TreeNode rightTreeNode = new TreeNode(1);
        rightTreeNode.right = new TreeNode(3);
        rightTreeNode.left = new TreeNode(2);

        final Q100相同的树 q100 = new Q100相同的树();
        final boolean sameTree = q100.isSameTree(leftTreeNode, rightTreeNode);
        System.out.println("some tree    " + sameTree);
    }
}

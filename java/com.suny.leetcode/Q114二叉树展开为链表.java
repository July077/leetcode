import common.TreeNode;

/**
 * 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author sunjianrong
 * @date 2021/7/7 下午10:15
 */
public class Q114二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);

        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }

        flatten(right);
        root.right = right;

    }
}

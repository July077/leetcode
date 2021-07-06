import common.ListNode;
import common.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author sunjianrong
 * @date 2021-07-06 9:17
 */
public class Q109有序链表转换二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode p = head;
        ListNode q = head;
        ListNode pre = null;

        // 快慢指针查找中心节点
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }

        // 切割链表  head变为pre左边   p为pre右边
        pre.next = null;

        final TreeNode treeNode = new TreeNode(p.val);

        // 递归构建左子树右子树
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(p.next);

        return treeNode;
    }

}

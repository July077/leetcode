import common.Node;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * @author sunjianrong
 * @date 2021/7/8 下午10:42
 */
public class Q117填充每个节点的下一个右侧节点指针II {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            // pre 表示下一层节点的前一个节点
            Node pre = dummy;
            // 遍历当前层链表
            while (cur != null) {
                if (cur.left != null) {
                    // 左节点不为空,就让 pre节点的 next 指向它
                    pre.next = cur.left;
                    pre = pre.next;
                }

                // 参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }

                // 访问下一个节点
                cur = cur.next;
            }

            // 串成链表后,赋值给 cur,循环直到 cur为空
            cur = dummy.next;
        }

        return root;

    }
}

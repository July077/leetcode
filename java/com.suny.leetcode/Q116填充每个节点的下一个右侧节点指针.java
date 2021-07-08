import common.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * @author sunjianrong
 * @date 2021-07-08 12:03
 */
public class Q116填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node pre = root;
        // 循环条件是当亲啊节点的左子树不为空,当只有根节点或者所有叶子节点时就循环退出了
        while (pre.left != null) {
            Node tmp = pre;
            while (tmp != null) {
                // 将 tmp 的左右节点串联起来
                tmp.left.next = tmp.right;

                // 下一个不为空则说明说一层已经完成串联了
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }

                // 继续右边的遍历
                tmp = tmp.next;
            }

            // 从下一层的最左边开始遍历
            pre = pre.left;
        }

        return root;

    }
}

package offer2;

import common.Node;

/**
 * 剑指 Offer II 028. 展平多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 * <p>
 * 
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/16 下午9:27
 */
public class Q028展平多级双向链表 {

    private Node ans;
    private Node cur;


    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        dfs(head);
        return ans;

    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }

        // 相当于前序遍历的主体,把遍历到的当前节点放到新的链表里面去
        if (cur == null) {
            ans = new Node();
            ans.val = node.val;
            cur = ans;
        } else {
            Node newNode = new Node();
            newNode.val = node.val;
            cur.next = newNode;
            newNode.prev = cur;
            cur = newNode;
        }

        // 有限迭代子节点,再迭代下一个子节点
        dfs(node.child);
        dfs(node.next);
    }
}

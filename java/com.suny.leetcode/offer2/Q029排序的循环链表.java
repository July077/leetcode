package offer2;

import common.Node;

/**
 * 剑指 Offer II 029. 排序的循环链表
 * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * <p>
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/16 下午9:45
 */
public class Q029排序的循环链表 {

    public Node insert(Node head, int insertVal) {
        // 新建一个链表形成环
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        // 用max 来处理插入之小于当前最小值和大于当前大值的情况
        Node cur = head;
        Node max = null;
        while (cur.next != head) {
            // 找出大于当前值,小于等于下一个值的插入点
            if (cur.val <= insertVal && cur.next.val >= insertVal) {
                break;
            }
            // 升序
            if (cur.val > cur.next.val) {
                max = cur;
            }
            cur = cur.next;
        }

        // 遍历完没找到升序的尾部,那肯定就是 head 前一个Node
        if (max == null) {
            max = cur;
        }

        // 成功找到大于等于当前值,小于等于下一个值的插入点
        if (cur.val <= insertVal && cur.next.val >= insertVal) {
            Node node = new Node();
            node.val = insertVal;
            node.next = cur.next;
            cur.next = node;
        } else {
            Node node = new Node();
            node.val = insertVal;
            node.next = max.next;
            max.next = node;
        }

        return head;

    }
}

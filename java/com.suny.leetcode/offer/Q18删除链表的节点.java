package offer;

import common.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-27 14:53
 */
public class Q18删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        if (cur != null) {
            pre.next = cur.next;
        }

        return head;
    }
}

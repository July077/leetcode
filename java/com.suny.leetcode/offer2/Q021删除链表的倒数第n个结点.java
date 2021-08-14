package offer2;

import common.ListNode;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @author sunjianrong
 * @date 2021/8/14 下午8:58
 */
public class Q021删除链表的倒数第n个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);

        // 先计算长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        ListNode curr = dummy;
        for (int i = 0; i < length - n + 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = null;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;

        Q021删除链表的倒数第n个结点 q21 = new Q021删除链表的倒数第n个结点();
        ListNode listNode = q21.removeNthFromEnd(node1, 2);
        listNode.printNode();


    }

}

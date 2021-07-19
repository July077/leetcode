import common.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author sunjianrong
 * @date 2021/7/18 上午9:55
 */
public class Q206反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }

        return pre;

    }
}

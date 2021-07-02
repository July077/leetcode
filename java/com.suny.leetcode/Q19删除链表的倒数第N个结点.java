import common.ListNode;

/**
 * @author sunjianrong
 * @date 2021/5/12 下午10:15
 */
public class Q19删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }

        return length;
    }
}


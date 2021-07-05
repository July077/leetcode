import common.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author sunjianrong
 * @date 2021/5/18 下午8:44
 */
public class Q24SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode first = cur;
            ListNode second = cur.next;
            ListNode third = cur.next.next;

            pre.next = second;
            second.next = first;
            first.next = third;

            // cur 后移两位  pre后移动两位
            pre = first;
            cur = third;
        }

        return dummy.next;
    }

}
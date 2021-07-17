import common.ListNode;

/**
 * 148. 排序链表
 * <p>
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/17 下午10:45
 */
public class Q148排序链表 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        // 快慢指针找出中点位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        // 断开链表
        slow.next = null;


        ListNode left = sortList(head);
        // 对右半部分进行归并排序
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;

        // 合并链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        h.next = left != null ? left : right;
        return res.next;
    }

}

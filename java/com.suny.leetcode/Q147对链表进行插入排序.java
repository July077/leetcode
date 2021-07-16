import common.ListNode;

/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 * @author sunjianrong
 * @date 2021/7/16 下午10:54
 */
public class Q147对链表进行插入排序 {


    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 创建头结点新链表
        ListNode dummyHead = new ListNode(0);
        // 依次取原链表的值
        ListNode p = head;
        // 寻找插入位置
        ListNode pre = dummyHead;

        while (p != null) {
            // 记录下当前 p 指针的节点,防止原链表断链,取当前值的下一个
            ListNode q = p.next;
            pre = dummyHead;
            // 寻找插入位置
            while (pre.next != null && pre.next.val < p.val) {
                pre = pre.next;
            }

            p.next = pre.next;
            pre.next = p;
            p = q;
        }

        return dummyHead.next;

    }
}

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @author sunjianrong
 * @date 2021-06-30 9:11
 */
public class Q92反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // init
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // move
        for (int step = 0; step < left - 1; step++) {
            // g 移动到左边界前
            g = g.next;
            // p 移动到左边界第一个
            p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < right - left; i++) {
            // 移除 p 后面的节点
            ListNode removed = p.next;
            p.next = p.next.next;

            // 将移除的节点指向 g 的后一个位置
            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

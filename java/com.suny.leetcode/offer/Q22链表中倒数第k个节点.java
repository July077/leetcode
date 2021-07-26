package offer;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/26 下午2:25
 */
public class Q22链表中倒数第k个节点 {
    public ListNode getKthFromEnd0(ListNode head, int k) {
        // 快慢指针  快指针先往前走K步，然后开始一起往前走，间距一直会是K，所以快指针到头了，慢指针就到了倒数第K个节点
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if (k > list.size()) {
            return null;
        }

        return list.get(list.size() - k);

    }

}

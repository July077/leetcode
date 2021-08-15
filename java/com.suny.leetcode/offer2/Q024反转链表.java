package offer2;

import common.ListNode;

/**
 * 剑指 Offer II 024. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * @author sunjianrong
 * @date 2021/8/15 下午9:37
 */
public class Q024反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmpNext = curr.next;

            curr.next = pre;
            pre = curr;
            curr = tmpNext;
        }

        return pre;

    }

}

package offer2;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 027. 回文链表
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * <p>
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 *
 * @author sunjianrong
 * @date 2021-08-16 12:16
 */
public class Q027回文链表 {

    public boolean isPalindrome0(ListNode head) {
        if (head == null) {
            return true;
        }

        final ListNode midListNode = findMid(head);
        final ListNode reverseListNode = reverseList(midListNode.next);

        boolean isPalindrome = true;
        ListNode p1 = head;
        ListNode p2 = reverseListNode;
        while (isPalindrome && p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        midListNode.next = reverseList(reverseListNode);
        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            final ListNode tmpNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmpNext;
        }
        return pre;
    }


    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }


        int left = 0;
        int right = res.size() - 1;

        while (left < right) {
            if (!res.get(left).equals(res.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}

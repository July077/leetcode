package offer;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 *
 * @author sunjianrong
 * @date 2021/7/21 下午10:37
 */
public class Q52两个链表的第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        // 互相遍历
        // 如果整个过程中都没有 a=b ，就没有共同的节点, 退出的条件就是  a=b=null
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }

        }

        return a;

    }

    public ListNode hashmap(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null && !set.contains(headB)) {
            headB = headB.next;
        }

        return headB;

    }


    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        for (ListNode node1 = headA; node1 != null; node1 = headA.next) {
            for (ListNode node2 = headB; node2 != null; node2 = node2.next) {
                if (node1 == node2) {
                    return node1;
                }
            }
        }

        return null;
    }
}

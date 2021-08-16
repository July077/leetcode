package offer2;

import common.ListNode;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 * 给定两个单链表的头节点headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * @author sunjianrong
 * @date 2021/8/14 下午10:56
 */
public class Q023两个链表的第一个重合节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            // 如果A已经走完了,就开始从B的起点走一圈
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }

            // 如果B已经走完了,就开始从A的起点走一圈
            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }

        return a;

    }
}

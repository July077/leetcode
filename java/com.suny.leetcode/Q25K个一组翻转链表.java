import common.ListNode;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/2 下午10:39
 */
public class Q25K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化 pre 、end 指向 dummy
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            // 如果 end 为空即反转的链表节点小于k，不执行翻转
            if (end == null) {
                break;
            }

            // 记录下 end.next 方便后面连接链表
            ListNode next = end.next;
            // 断开链表
            end.next = null;
            // 记录下需要翻转的头结点
            ListNode start = pre.next;
            // 翻转链表  pre.next 指向翻转后的链表  1>2 变成 2>1     dummy>2>1
            pre.next = reverse(start);
            // 翻转后头结点到最后
            start.next = next;
            // 讲 pre 换成下次药翻转的链表的头结点的上一个节点
            pre = start;
            // 翻转结束
            end = start;
        }

        return dummy.next;


    }


    public ListNode reverse(ListNode head) {
        // 单链表为空或者只有一个节点就直接返回单链表
        if (head == null || head.next == null) {
            return head;
        }
        // 前一个指针节点
        ListNode preNode = null;
        // 当前节点指针
        ListNode curNode = head;
        // 下一个节点指针
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }
}

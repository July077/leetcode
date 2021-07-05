import common.ListNode;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * @author sunjianrong
 * @date 2021-06-18 12:09
 */
public class Q61旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        // 计算链表的长度
        int num = 0;
        ListNode temp = head;
        ListNode last = head;
        while (temp != null) {
            last = temp;
            temp = temp.next;
            num++;
        }

        // 将单链表变成环
        last.next = head;

        // 新链表的最后一个节点 = 链表的长度 - ( k % num)
        int size = num - k % num;
        temp = head;

        for (int i = 0; i < size; i++) {
            last = temp;
            temp = temp.next;
        }

        head = last.next;
        last.next = null;
        return head;


    }


}

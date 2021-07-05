import common.ListNode;

/**
 * 86. 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/6/26 下午11:11
 */
public class Q86分隔链表 {

    public ListNode partition(ListNode head, int x) {
        // 小链表
        ListNode small = new ListNode(0);
        ListNode smallHead = small;

        // 大链表
        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                // 添加到小链表
                small.next = head;
                small = small.next;
            } else {
                // 添加到大链表
                large.next = head;
                large = large.next;
            }

            head = head.next;
        }

        // 合并链表,大链表后续置空
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;

    }

    public static void main(String[] args) {
        Q86分隔链表 q86 = new Q86分隔链表();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(2);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(2);
        node5.next = node6;


        ListNode partition = q86.partition(head, 3);

        StringBuilder sb = new StringBuilder();
        sb.append(partition.val).append(" ");
        ListNode currNode = partition;
        while (currNode.next != null) {
            currNode = currNode.next;
            sb.append(currNode.val).append(" ");
        }

        System.out.println(sb.toString());
    }


}

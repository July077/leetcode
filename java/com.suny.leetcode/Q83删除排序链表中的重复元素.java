import common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 *
 * @author sunjianrong
 * @date 2021/6/25 下午10:51
 */
public class Q83删除排序链表中的重复元素 {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            // 如果当前节点跟下个节点相等,那么就将下下个节点搬到下个节点,因为只要求保留一个重复的
            //  1 1 2  >  1 2
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                // 当前节点跟下个节点不相等,将下个节点赋值为当前节点
                // [1] 2 3 >   1 [2] 3
                curr = curr.next;
            }
        }

        return head;


    }


    public ListNode deleteDuplicates0(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }


        head.next = deleteDuplicates0(head.next);

        if (head.val == head.next.val) {
            head = head.next;
        }

        return head;

    }

}

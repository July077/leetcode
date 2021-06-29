/**
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 *
 * @author sunjianrong
 * @date 2021/6/25 下午10:21
 */
public class Q82删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;

        // 1 > 1 > 1 > 2 > 3
        // 这种情况说明需要舍弃头结点
        if (head.val == next.val) {

            // 一直循环找到下一个跟当前头结点不相等的节点.  移动 next 跟 head.value 不相等的情况
            while (next != null && head.val == next.val) {
                next = next.next;
            }

            // 这个时候头结点不要了，已经重复了
            head = deleteDuplicates(next);
        } else {

//            1 > 2> 3
            // 头结点需要被保留，因为头结点跟下一节点值不相等。下一个节点跟下下个节点的值需要递归比较
            head.next = deleteDuplicates(next);
        }

        return head;

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

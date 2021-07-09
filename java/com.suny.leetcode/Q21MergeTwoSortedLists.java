import common.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author sunjianrong
 * @date 2021/5/15 下午11:14
 */
public class Q21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            System.out.println("l1的值小，摘出l1");
            System.out.println("l1.val = " + l1.val);
            l1.next = mergeTwoLists(l1.next, l2);
            System.out.println("l1.val = " + l1.val);
            return l1;
        } else {
            System.out.println("l2的值小，摘出l2");
            System.out.println("l2.val = " + l2.val);
            l2.next = mergeTwoLists(l1, l2.next);
            System.out.println("l2.val = " + l2.val);
            return l2;
        }


    }
}

package offer2;

import common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer II 078. 合并排序链表
 * <p>
 * 给定一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/2 下午10:08
 */
public class Q078合并排序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }

}

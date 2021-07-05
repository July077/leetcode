import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author sunjianrong
 * @date 2021/5/17 下午8:59
 */
public class Q23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode cur = new ListNode();
        ListNode ans = cur;

        if (lists.length == 0) {
            return cur.next;
        }


        Queue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }

        return ans.next;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);


        ListNode node2 = new ListNode();
        node2.val = 1;
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);


        ListNode node3 = new ListNode();
        node3.val = 2;
        node3.next = new ListNode(6);


        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = node1;
        listNodes[1] = node1;
        listNodes[2] = node1;

        Q23MergeKSortedLists sortedLists = new Q23MergeKSortedLists();
        ListNode listNode = sortedLists.mergeKLists(listNodes);
        System.out.println(listNode);


    }
}




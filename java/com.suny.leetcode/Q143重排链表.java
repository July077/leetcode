import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * <p>
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/15 下午10:39
 */
public class Q143重排链表 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }

            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;

    }
}

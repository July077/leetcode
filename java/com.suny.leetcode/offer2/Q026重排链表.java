package offer2;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 026. 重排链表
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 * <p>
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/15 下午10:07
 */
public class Q026重排链表 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 存到 list 中
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }

            list.get(right).next = list.get(left);
            right--;
        }

        list.get(left).next = null;

    }

}

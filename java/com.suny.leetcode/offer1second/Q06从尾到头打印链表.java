package offer1second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import common.ListNode;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 
 * 
 * 限制：
 * 
 * 0 <= 链表长度 <= 10000
 */
public class Q06从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }

        return res;
    }

}

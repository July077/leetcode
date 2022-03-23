package top100;

import java.util.ArrayList;
import java.util.List;

import common.ListNode;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2]
 * 输出：false
 * 
 * 
 * 提示：
 * 
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * 
 * 
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Q234回文链表 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> nodeValues = new ArrayList<>();

        ListNode tmpNode = head;
        while (tmpNode != null) {
            nodeValues.add(tmpNode.val);
            tmpNode = tmpNode.next;
        }

        int left = 0;
        int right = nodeValues.size() - 1;
        while (left < right) {
            if (nodeValues.get(left) != nodeValues.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

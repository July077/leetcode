package offer;

import common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/28 下午9:12
 */
public class Q35复杂链表的复制 {
    public Node copyRandomList0(Node head) {
        if (head == null) {
            return head;
        }

        Node node = head;
        // 在原节点后面复制一个值相同的节点
        while (node != null) {
            // 1 > 2 > 3  >>>>>   1> 1> 2 > 3
            // 克隆节点的next就是当前节点的 Next
            // 当前节点的next就是克隆节点
            // 下一次遍历的节点就是克隆节点的 Next
            Node cloneNode = new Node(node.val);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }

        // 完成随机指针的复制
        node = head;
        Node cloneNode = head.next;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }


        // 拆分链表
        node = head;
        Node cloneHead = head.next;
        cloneNode = cloneHead;
        while (node != null) {
            node.next = cloneNode.next;
            node = node.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
                cloneNode = cloneNode.next;
            }
        }

        return cloneHead;

    }

    // 克隆一个链表
    public Node copyRandomList(Node head) {
        /**
         * 1. 整体思路,使用哈希表把原节点跟克隆的节点存起来
         * 2. 然后把原链表跟克隆的链表重新组织一遍
         */
        if (head == null) {
            return null;
        }

        Node cur = head;
        Map<Node, Node> map = new HashMap<>();

        //复制当前节点,并建立  原节点 > 新节点 的映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        // 构建新的链表 next 和 random 指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        // 返回新链表的头结点
        return map.get(head);
    }
}

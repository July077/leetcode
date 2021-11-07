import common.ListNode;

/**
 * 237. 删除链表中的节点
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问 要被删除的节点 。
 * <p>
 * 题目数据保证需要删除的节点 不是末尾节点 。
 * <p>
 *
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 *
 * @author sunjianrong
 * @date 2021-11-02 9:28
 */
public class Q237删除链表中的节点 {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

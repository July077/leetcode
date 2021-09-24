import common.Node;

/**
 * 430. 扁平化多级双向链表
 * <p>
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 *
 * @author sunjianrong
 * @date 2021-09-24 22:27
 */
public class Q430扁平化多级双向链表 {

    public Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {
            if (head.child == null) {
                head = head.next;
            } else {
                Node tmp = head.next;
                Node chead = flatten(head.child);
                head.next = chead;
                chead.prev = head;

                head.child = null;
                while (head.next != null) {
                    head = head.next;
                }
                head.next = tmp;
                if (tmp != null) {
                    tmp.prev = head;
                }
                head = tmp;
            }
        }
        return dummy.next;
    }

}

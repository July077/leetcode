import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 725. 分隔链表
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 *
 * @author sunjianrong
 * @date 2021-09-22 19:25
 */
public class Q725分隔链表 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        List<ListNode> lst = new ArrayList<>();
        //链表存list
        while (head != null) {
            lst.add(head);
            head = head.next;
        }
        int len = lst.size();
        //得到每段最小值division和取k段division后剩余长度surplus
        int division = len / k, surplus = len % k;
        //当前需要分割的链表头节点（即需要存入res的节点）
        int index = 0;
        //当前已经存入段数（标记存入res的位置）
        int sign = 0;
        //不断分割直到链表分割结束
        while (index < len) {
            //链表头节点为在lst中的标记为index
            int l = index;
            //surplus（剩余长度）大于0时，需多分配一单位的节点，反之不用（求当前被分段的尾节点标记，方便断链）
            int r = surplus > 0 ? index + division : index + division - 1;
            //剩余的长度-1
            surplus--;
            res[sign++] = lst.get(l);
            //断链（r >= len时，已经是最后一段，无需断链）
            if (r < len) {
                lst.get(r).next = null;
            }
            //更新下一段头节点的位置
            index = r + 1;
        }
        return res;
    }

}

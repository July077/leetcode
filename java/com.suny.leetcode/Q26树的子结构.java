import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 26. 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4  5
 * / \
 * 1  2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunjianrong
 * @date 2021/7/24 下午10:06
 */
public class Q26树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == B.val) {
                if (helper(node, B)) {
                    return true;
                }
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false;
    }

    private boolean helper(TreeNode nodeA, TreeNode nodeB) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.offer(nodeA);
        queueB.offer(nodeB);


        while (!queueB.isEmpty()) {
            nodeA = queueA.poll();
            nodeB = queueB.poll();

            if (nodeA == null || nodeA.val != nodeB.val) {
                return false;
            }

            if (nodeB.left != null) {
                queueA.offer(nodeA.left);
                queueB.offer(nodeB.left);
            }

            if (nodeB.right != null) {
                queueA.offer(nodeA.left);
                queueB.offer(nodeB.right);
            }


        }

        return true;

    }
}

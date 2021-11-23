import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 
 * <p>
 * 示例1：
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-23 12:04
 */
public class Q515在每个树行中找最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int size = queue.size();
            int max = queue.getFirst().getVal();

            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.removeFirst();
                if (node == null) {
                    continue;
                }
                final int val = node.val;
                if (val > max) {
                    max = val;
                }

                if(node.left!= null){
                    queue.offer(node.left);
                }

                if(node.right!= null){
                    queue.offer(node.right);
                }
            }

            res.add(max);

        }
        return res;
    }
}

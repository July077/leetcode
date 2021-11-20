import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 *
 * <p>
 * 示例 1：
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -3
 * 返回[2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * <p>
 * 示例2：
 * 输入：
 * <p>
 * 5
 * /  \
 * 2   -5
 * 返回[2]，只有 2 出现两次，-5 只出现 1 次。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-16 12:01
 */
public class Q508出现次数最多的子树元素和 {


    private Map<Integer, Integer> res = new HashMap<>();
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        postOrder(root);
        Set<Integer> keys = res.keySet();
        int n = 0;
        for (Integer i : keys) {
            if (res.get(i) == max) {
                n++;
            }
        }

        int[] ans = new int[n];
        n = 0;

        for (Integer s : keys) {
            if (res.get(s) == max) {
                ans[n++] = s;
            }
        }
        return ans;
    }


    private int postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int left = postOrder(treeNode.left);
        int right = postOrder(treeNode.right);

        int sum = treeNode.val + left + right;
        res.put(sum, res.getOrDefault(sum, 0) + 1);
        max = Math.max(max, res.get(sum));
        return sum;
    }
}

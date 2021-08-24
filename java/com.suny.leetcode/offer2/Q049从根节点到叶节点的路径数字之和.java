package offer2;

import common.TreeNode;

/**
 * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
 * <p>
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * <p>
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * @author sunjianrong
 * @date 2021/8/23 下午9:46
 */
public class Q049从根节点到叶节点的路径数字之和 {


    public int sumNumbers(TreeNode root) {
        return backtrack(root, 0);
    }

    private int backtrack(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int sum = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return backtrack(root.left, sum) + backtrack(root.right, sum);
    }
}

package offer2;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 050. 向下的路径节点之和
 * <p>
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-24 12:01
 */
public class Q050向下的路径节点之和 {
    private Map<Integer, Integer> map = new HashMap<>();
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        map.put(0, 1);
        return dfs(root, 0);
    }

    private int dfs(TreeNode treeNode, int curSum) {
        if (treeNode == null) {
            return 0;
        }

        curSum += treeNode.val;
        int res = 0;

        // 得到我们想要的前缀树个数
        res = map.getOrDefault(curSum - target, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        int left = dfs(treeNode.left, curSum);
        int right = dfs(treeNode.right, curSum);

        // 防止左子树前缀和影响右子树
        map.put(curSum, map.get(curSum) - 1);

        // 当前节点前缀个数加上左右子树的个数
        return res + left + right;
    }
}

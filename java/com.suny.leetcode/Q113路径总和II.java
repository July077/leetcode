import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author sunjianrong
 * @date 2021/7/7 下午9:50
 */
public class Q113路径总和II {

    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }

        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        if (root.left != null) {
            path.add(root.val);
            dfs(root.left, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.val);
            dfs(root.right, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }
    }
}

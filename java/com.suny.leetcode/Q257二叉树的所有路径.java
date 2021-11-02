import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 *
 * @author sunjianrong
 * @date 2021-11-02 12:08
 */
public class Q257二叉树的所有路径 {

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode node, String path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            res.add(path + node.val);
            return;
        }

        final String p = path + node.val + "->";
        dfs(node.left, p);
        dfs(node.right, p);
    }
}

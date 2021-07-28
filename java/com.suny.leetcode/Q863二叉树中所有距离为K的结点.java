import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * <p>
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-28 9:23
 */
public class Q863二叉树中所有距离为K的结点 {
    private Map<Integer, TreeNode> parents = new HashMap<>();
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // 从 root 出发 DFS，记录每个节点的父节点
        findParents(root);

        // 从 target 触发 dfs ,寻找所有深度为 K 的节点
        findAns(target, null, 0, k);

        return ans;
    }

    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }

        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }


    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }

        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }

        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }

        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }


    }
}

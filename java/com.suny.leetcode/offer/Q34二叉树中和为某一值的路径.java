package offer;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * <p>
 * 入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 *
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/1 下午9:42
 */
public class Q34二叉树中和为某一值的路径 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }


    private void recur(TreeNode treeNode, int tar) {
        if (treeNode == null) {
            return;
        }

        path.add(treeNode.val);
        tar = tar - treeNode.val;
        // 必须是叶子节点
        if (tar == 0 && treeNode.left == null && treeNode.right == null) {
            res.add(new LinkedList<>(path));
        }

        recur(treeNode.left, tar);
        recur(treeNode.right, tar);

        // 回溯到上一节点
        path.removeLast();

    }

}

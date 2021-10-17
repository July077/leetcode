import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * @author sunjianrong
 * @date 2021/10/17 上午10:54
 */
public class Q230二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);

        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode ll = new TreeNode();
        TreeNode lr = new TreeNode(2);
        left.left = ll;
        left.right = lr;


        treeNode.left = left;
        treeNode.right = right;


        Q230二叉搜索树中第K小的元素 q230 = new Q230二叉搜索树中第K小的元素();
        q230.kthSmallest(treeNode, 1);
    }
}

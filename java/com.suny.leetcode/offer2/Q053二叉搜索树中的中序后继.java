package offer2;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 * <p>
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * <p>
 * 节点p的后继是值比p.val大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 * <p>
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * <p>
 *
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-25 12:06
 */
public class Q053二叉搜索树中的中序后继 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while (root != null) {
            if (p.val < root.val) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }


    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {

        List<TreeNode> res = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            final int size = stack.size();
            for (int i = 0; i < size; i++) {
                final TreeNode pop = stack.pop();
                if (pop == null) {
                    continue;
                }
                stack.push(pop.left);
                res.add(pop);
                stack.push(pop.right);
            }
        }

        // 寻找中序的下一个节点
        for (int i = 0; i < res.size(); i++) {
            final TreeNode treeNode = res.get(i);
            if (treeNode != null && treeNode.val == p.val) {
                return res.get(i + 1);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        final Q053二叉搜索树中的中序后继 q53 = new Q053二叉搜索树中的中序后继();

        final TreeNode treeNode1 = new TreeNode(2);
        final TreeNode treeNode2 = new TreeNode(1);
        final TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        System.out.println(q53.inorderSuccessor(treeNode1, treeNode1).val);
    }
}

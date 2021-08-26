package offer2;

import common.TreeNode;

import java.util.HashSet;

/**
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 * <p>
 * 给定一个二叉搜索树的 根节点 root和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-26 12:07
 */
public class Q056二叉搜索树中两个节点之和 {

    private final HashSet<Integer> res = new HashSet<>();


    // 方法二，边遍历边判断
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }


    private boolean dfs(TreeNode treeNode, int k) {
        if (treeNode == null) {
            return false;
        }

        if (res.contains(k - treeNode.val)) {
            return true;
        }

        res.add(treeNode.val);

        return dfs(treeNode.left, k) || dfs(treeNode.right, k);
    }


    // 方法一 直接 hashet 判断二数之和
    public boolean findTarget1(TreeNode root, int k) {
        dfs1(root);

        for (Integer i : res) {
            // 因为没有重复的,所以得排除 k-i 等于 i 的情况
            if (res.contains(k - i) && (k - i) != i) {
                return true;
            }
        }

        return false;

    }

    private void dfs1(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        dfs1(treeNode.left);
        res.add(treeNode.val);
        dfs1(treeNode.right);
    }

    public static void main(String[] args) {
        final Q056二叉搜索树中两个节点之和 q56 = new Q056二叉搜索树中两个节点之和();
        final int[] res = {8, 6, 10, 5, 7, 9, 11, 22};
        final HashSet<Integer> hashSet = new HashSet<>();

        for (Integer i : res) {
            hashSet.add(i);
        }
        int k = 22;
        for (Integer i : res) {
            if (hashSet.contains(k - i) && (k - i) != i) {
                System.out.println("找到");
                break;
            }
        }


    }


}

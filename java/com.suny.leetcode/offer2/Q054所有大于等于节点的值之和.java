package offer2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 * <p>
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * <p>
 *
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * <p>
 * <p>
 * 输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/25 下午9:35
 */
public class Q054所有大于等于节点的值之和 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;

        convertBST(root.left);
        return root;
    }

    private List<Integer> orderList = new ArrayList<>();

    public TreeNode convertBST1(TreeNode root) {
        dfs(root);
        replaceDfs(root);
        return root;
    }


    private void replaceDfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        dfs(treeNode.left);

        int val = treeNode.val;
        treeNode.val = orderList.stream().filter(v -> v >= val).mapToInt(Integer::intValue).sum();
        orderList.add(treeNode.val);
        dfs(treeNode.right);
    }


    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        dfs(treeNode.left);
        orderList.add(treeNode.val);
        dfs(treeNode.right);
    }

}

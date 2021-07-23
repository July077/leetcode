import common.TreeNode;

import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author sunjianrong
 * @date 2021-07-22 19:53
 */
public class Q07重建二叉树 {

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return new TreeNode();
        }
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return rebuild(0, 0, inorder.length - 1);
    }


    private TreeNode rebuild(int root, int left, int right) {
        if (left > right) {
            return null;
        }

        int i = map.get(preorder[root]);

        TreeNode node = new TreeNode(preorder[root]);

        // 寻找左边节点
        node.left = rebuild(root + 1, left, i - 1);

        // 寻找右边节点
        node.right = rebuild(root + i - left + 1, i + 1, right);

        return node;
    }
}

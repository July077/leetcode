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
        // 找出根节点
        final TreeNode treeNode = new TreeNode();
        if (null == preorder || null == inorder || 0 == preorder.length || inorder.length == 1) {
            return treeNode;
        }

        final int rootVal = preorder[0];
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return rebuild(0, 0, inorder.length - 1);
    }


    private TreeNode rebuild(int preRootIndex, int inLeftIndex, int inRightIndex) {
        if (inLeftIndex > inRightIndex) {
            return null;
        }

        int inRootIndex = map.get(preorder[preRootIndex]);

        TreeNode node = new TreeNode(preorder[preRootIndex]);

        // 寻找左边节点
        node.left = rebuild(preRootIndex + 1, inLeftIndex, inRootIndex - 1);

        // 寻找右边节点
        node.right = rebuild(preRootIndex + inRootIndex - inLeftIndex + 1, inRootIndex + 1, inRootIndex);

        return node;
    }
}

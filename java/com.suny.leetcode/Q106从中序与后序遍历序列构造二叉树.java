import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author sunjianrong
 * @date 2021/7/5 下午8:26
 */
public class Q106从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree0(int[] inorder, int[] postorder) {
        return buildTree00(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }


    public TreeNode buildTree00(int[] inorder, int inleft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (inRight - inleft < 1) {
            return null;
        }

        //还一个元素
        if (inRight - inleft == 1) {
            return new TreeNode(inorder[inleft]);
        }

        // 后续数组最后一个节点为根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(rootValue);
        int rootIndex = 0;

        for (int i = inleft; i < inRight; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
            }
        }

        rootNode.left = buildTree00(inorder, inleft, rootIndex, postorder, postLeft, postLeft + (rootIndex - inleft));

        rootNode.right = buildTree00(inorder, rootIndex + 1, inRight, postorder, postLeft + (rootIndex - inleft), postRight - 1);

        return rootNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 找出根节点
        if (null == postorder || postorder.length == 0) {
            return null;
        }

        int rootValue = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(rootValue);

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(rootNode);

        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            // 后续遍历 该节点是栈顶元素的做节点或者右节点 ,若是有右节点则一定是右节点
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();

            // 此时栈顶元素的值不等于中序遍历最后一个值
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                // 当栈顶元素 == 中序遍历最后一个时,该节点没有右节点
                // 反向中序遍历 该节点后面一定是左节点或者是双亲节点
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }

                // 左节点入栈
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }


        }

        return rootNode;

    }
}

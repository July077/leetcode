import common.TreeNode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author sunjianrong
 * @date 2021-07-05 12:05
 */
public class Q105从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preOrder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart == pEnd) {
            return null;
        }

        int rootVal = preOrder[pStart];
        TreeNode rootNode = new TreeNode(rootVal);

        // 中序遍历找出 中序遍历中根节点的索引位置
        int inRootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (rootVal == inorder[i]) {
                inRootIndex = i;
                break;
            }
        }


        // 左子树的范围为  [1 - 中序根节点索引位置]   右子树的范围为 [中序根节点的所以位置 - 数组最后]

        int leftNum = inRootIndex - inStart;

        // 递归构造左子树
        rootNode.left = buildTreeHelper(preOrder, pStart + 1, pStart + leftNum + 1, inorder, inStart, inRootIndex);

        // 递归构造右子树

        rootNode.right = buildTreeHelper(preOrder, pStart + leftNum + 1, pEnd, inorder, inRootIndex + 1, inEnd);

        return rootNode;
    }


    public TreeNode buildTree0(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; ++i) {
            //用preorder[0]去中序数组中查找对应的元素
            if (preorder[0] == inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree0(preLeft, inLeft);
                root.right = buildTree0(preRight, inRight);
                break;
            }
        }
        return root;
    }

}

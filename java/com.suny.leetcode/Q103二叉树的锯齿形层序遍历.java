import common.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 * @author sunjianrong
 * @date 2021/7/4 下午11:15
 */
public class Q103二叉树的锯齿形层序遍历 {


    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }

        int count = 0;
//        boolean isPositive = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }


            }

            if (count % 2 == 1) {
                Collections.reverse(list);
            }
            count++;
            res.add(list);
        }

        return res;
    }

    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        if (root != null) {
            queue1.add(root);
        }

        int level = 1;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            boolean inorder = (level & 1) == 1;
            int size = inorder ? queue1.size() : queue2.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                if (inorder) {
                    TreeNode treeNode = queue1.poll();
                    list.add(treeNode.val);

                    if (treeNode.left != null) {
                        queue2.add(treeNode.left);
                    }

                    if (treeNode.right != null) {
                        queue2.add(treeNode.right);
                    }
                } else {
                    TreeNode treeNode = queue2.poll();
                    list.add(treeNode.val);

                    if (treeNode.right != null) {
                        queue1.add(treeNode.right);
                    }

                    if (treeNode.left != null) {
                        queue1.add(treeNode.left);
                    }
                }

            }

            level++;
            res.add(list);
        }

        return res;
    }*/
}

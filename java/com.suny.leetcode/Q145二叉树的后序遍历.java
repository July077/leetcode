import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * @author sunjianrong
 * @date 2021-07-14 12:08
 */
public class Q145二叉树的后序遍历 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);

        res.add(root.val);
        return res;
    }
}

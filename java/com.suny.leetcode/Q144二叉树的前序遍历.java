import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author sunjianrong
 * @date 2021/7/13 下午10:44
 */
public class Q144二叉树的前序遍历 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return res;
    }
}

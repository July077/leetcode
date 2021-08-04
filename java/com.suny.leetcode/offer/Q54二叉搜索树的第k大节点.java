package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/3 下午10:53
 */
public class Q54二叉搜索树的第k大节点 {

    int res;
    int k;

    public int kthLargest1(TreeNode root, int n) {
        k = n;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        // 中序是递增的  左中右    。  反过来右中左就是从大到小
        if (node == null || k == 0) {
            return;
        }
        dfs(node.right);

        // k为第几大的数字，一直减k次就是该数值
        if (--k == 0) {
            res = node.val;
            return;
        }

        dfs(node.left);
    }


    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(res.size() - k);
    }


    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            dfs(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            dfs(node.right, list);
        }
    }
}

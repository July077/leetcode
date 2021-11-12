import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @author sunjianrong
 * @date 2021-11-12 12:10
 */
public class Q501二叉搜索树中的众数 {

    private List<Integer> res = new ArrayList<>();
    private int base;
    private int count;
    private int maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] mode = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            mode[i] = res.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }


    private void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }

        if (count == maxCount) {
            res.add(base);
        }

        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(base);
        }

    }

}

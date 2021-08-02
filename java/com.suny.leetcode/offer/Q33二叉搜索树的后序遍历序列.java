package offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/31 下午1:52
 */
public class Q33二叉搜索树的后序遍历序列 {

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    boolean helper(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        int mid = left;
        // 根节点
        int root = postorder[right];
        while (postorder[mid] < root) {
            mid++;
        }

        int tmp = mid;
        while (tmp < right) {
            if (postorder[tmp++] < root) {
                return false;
            }
        }

        return helper(postorder, left, mid - 1) && helper(postorder, mid, right - 1);
    }


}

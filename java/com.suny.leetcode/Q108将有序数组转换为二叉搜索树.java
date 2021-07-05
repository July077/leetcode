import common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author sunjianrong
 * @date 2021/7/5 下午9:18
 */
public class Q108将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }


    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        // 以圣墟数组的中间元素作为根节点

        int mid = lo + (hi - lo) / 2;

        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = dfs(nums, lo, mid - 1);
        treeNode.right = dfs(nums, mid + 1, hi);

        return treeNode;
    }
}

package offer2;

import java.util.TreeSet;

/**
 * 剑指 Offer II 057. 值和下标之差都在给定的范围内
 * <p>
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/26 下午9:21
 */
public class Q057值和下标之差都在给定的范围内 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            long u = nums[i];
            // 在 treeSet 中找到小于 u 的最大值
            Long l = treeSet.floor(u);
            // 从 treeSet 中找到大于等于 u 的最小值
            Long r = treeSet.ceiling(u);

            if (l != null && u - l <= t) {
                return true;
            }

            if (r != null && r - u <= t) {
                return true;
            }

            // 将当前数添加到 ts 中，并移除下标范围不再 max(0,i-k) 的数
            treeSet.add(u);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }

        return false;
    }

}

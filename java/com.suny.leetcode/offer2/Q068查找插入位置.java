package offer2;

/**
 * 剑指 Offer II 068. 查找插入位置
 * <p>
 * 给定一个排序的整数数组 nums和一个整数目标值 target ，请在数组中找到target，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/30 下午9:04
 */
public class Q068查找插入位置 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}

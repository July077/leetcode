/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 *
 * @author sunjianrong
 * @date 2021/5/29 下午11:04
 */
public class Q35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                left = i;
                continue;
            }
            if (nums[i] > target) {
                return left + 1;
            }
        }
        return 0;

    }
}

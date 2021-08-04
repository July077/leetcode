package offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/3 下午10:31
 */
public class Q53IIn1中缺失的数字 {

    public int missingNumber0(int[] nums) {
        if (nums[0] == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中位数相等，说明左边的都是递增的，缺少的数值必然在右边的区间
            if (nums[mid] == mid) {
                left = mid + 1;
            }

            // 如果中位数不等于下标，则缺少的数值在左边
            if (nums[mid] != mid) {
                right = mid;
            }
        }

        return right;
    }
}

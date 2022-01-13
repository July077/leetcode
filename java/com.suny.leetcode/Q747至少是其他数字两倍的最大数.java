import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 747. 至少是其他数字两倍的最大数
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 示例 2：
 * 
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * 示例 3：
 * 
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 * 
 */
public class Q747至少是其他数字两倍的最大数 {

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] * 2 && nums[i] > nums[i - 2] * 2) {
                max = Math.max(max, nums[i]);
            }
        }

        if (map.get(max) != null) {
            return map.get(max);
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] params = new int[] { 3, 6, 1, 0 };
        Q747至少是其他数字两倍的最大数 q = new Q747至少是其他数字两倍的最大数();
        q.dominantIndex(params);
    }
}

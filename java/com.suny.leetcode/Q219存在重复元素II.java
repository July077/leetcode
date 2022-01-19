import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
 * - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * 
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * 
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */
public class Q219存在重复元素II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}

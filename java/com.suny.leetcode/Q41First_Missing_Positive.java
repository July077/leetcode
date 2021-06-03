import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * @author sunjianrong
 * @date 2021/6/3 下午8:46
 */
public class Q41First_Missing_Positive {

    public int binarySearchResolver(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i <= len; i++) {
            int res = binarySearch(nums, i);
            if (res == -1) {
                return i;
            }
        }

        return len + 1;

    }

    private int binarySearch(int[] nums, int targer) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == targer) {
                return mid;
            } else if (nums[mid] < targer) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

    public int hashset(int[] nums) {
        int length = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }

        return length + 1;

    }
}

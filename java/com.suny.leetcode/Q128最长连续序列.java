import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * <p>
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * @author sunjianrong
 * @date 2021-07-12 9:20
 */
public class Q128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                // 有更小的说明不是左边界
                continue;
            } else {
                int len = 0;
                // 循环判断是否有比当前数大的值
                while (set.contains(num++)) {
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }


}

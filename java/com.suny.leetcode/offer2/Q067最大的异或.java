package offer2;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 067. 最大的异或
 * <p>
 * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ms70jA
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunjianrong
 * @date 2021/8/30 下午8:31
 */
public class Q067最大的异或 {

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;

        for (int i = 30; i >= 0; i--) {
            // 注意保留前缀
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if(set.contains(prefix ^ temp)){
                    res = temp;
                    break;
                }
            }

        }

        return res;
    }
}

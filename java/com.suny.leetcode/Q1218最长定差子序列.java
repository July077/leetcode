import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * <p>
 * 给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * <p>
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例2：
 * <p>
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 * <p>
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-05 9:36
 */
public class Q1218最长定差子序列 {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 1;
        for (int num : arr) {
            int val = map.getOrDefault(num - difference, 0);
            map.put(num, ++val);
            ans = Math.max(ans, val);
        }
        return ans;

    }
}

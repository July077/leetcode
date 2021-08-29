/**
 * 1588. 所有奇数长度子数组的和
 * <p>
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr中 所有奇数长度子数组的和 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/29 上午9:31
 */
public class Q1588所有奇数长度子数组的和 {

    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            int leftOdd = (i + 1) / 2;
            int leftEven = i / 2 + 1;
            int rightOdd = (len - i) / 2;
            int rightEven = (len - 1 - i) / 2 + 1;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }

        return res;

    }
}

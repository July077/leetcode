package offer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 093. 最长斐波那契数列
 * <p>
 * 如果序列X_1, X_2, ..., X_n满足下列条件，就说它是斐波那契式的：
 * <p>
 * n >= 3
 * 对于所有i + 2 <= n，都有X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回0 。
 * <p>
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如，[3, 5, 8]是[3, 4, 5, 6, 7, 8]的一个子序列）
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例2：
 * <p>
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/7 下午9:10
 */
public class Q093最长斐波那契数列 {

    public int lenLongestFibSubseq(int[] arr) {
        int max = 2;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int i1 = arr[i];
                int j1 = arr[j];
                int sum = i1 + j1;
                int cur = 2;

                // exist
                while (Arrays.binarySearch(arr, sum) >= 0) {
                    i1 = j1;
                    j1 = sum;
                    sum = i1 + j1;
                    cur++;
                }
                max = Math.max(max, cur);

            }

        }
        return max < 3 ? 0 : max;

    }
}

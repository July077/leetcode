package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * <p>
 * 给定一个非负整数 n，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/8 下午10:57
 */
public class Q003前n个数字二进制中1的个数 {

    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 偶数
            if ((i & 1) == 0) {
                ans[i] = ans[i >> 1];
            } else {
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }


    public int[] countBits0(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < 31; j++) {
                if (((j >> 1) & 1) == 1) {
                    count++;
                }
            }
            res.add(count);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        Q003前n个数字二进制中1的个数 q03 = new Q003前n个数字二进制中1的个数();
        System.out.println(Arrays.toString(q03.countBits(2)));
    }
}

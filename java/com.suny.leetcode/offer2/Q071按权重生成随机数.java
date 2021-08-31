package offer2;

import java.util.Random;

/**
 * 剑指 Offer II 071. 按权重生成随机数
 * <p>
 * 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），请写一个函数pickIndex，它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比。
 * <p>
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
 * <p>
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-31 11:55
 */
public class Q071按权重生成随机数 {
    private Random random;
    private int[] preSum;


    public Q071按权重生成随机数(int[] w) {
        this.random = new Random();
        this.preSum = new int[w.length];
        // 计算前缀和
        this.preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            this.preSum[i] = this.preSum[i - 1] + w[i];
        }
    }


    public int pickIndex() {
        int max = this.preSum[this.preSum.length - 1];

        // 必须不包含0
        int rand = random.nextInt(max) + 1;

        for (int i = 0; i < preSum.length; i++) {
            // 判断落在哪个区间
            if (rand <= preSum[i]) {
                return i;
            }
        }

        return 0;

    }

}

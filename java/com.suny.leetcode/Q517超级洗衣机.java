import java.util.Arrays;

/**
 * 517. 超级洗衣机
 * 假设有 n台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * <p>
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * <p>
 * 给定一个整数数组machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：machines = [1,0,5]
 * 输出：3
 * 解释：
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-29 18:53
 */
public class Q517超级洗衣机 {

    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }

        int avg = tot / n;
        int ans = 0;
        int sum = 0;
        for (int machine : machines) {
            machine -= avg;
            sum += machine;
            ans = Math.max(ans, Math.max(Math.abs(sum), machine));
        }
        return ans;
    }
}

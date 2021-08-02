import java.util.*;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * <p>
 * 给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
 * <p>
 * 如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/1 下午9:22
 */
public class Q1337矩阵中战斗力最弱的K行 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        List<int[]> power = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int l = 0;
            int r = n - 1;
            int pos = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }

            power.add(new int[]{pos + 1, i});

        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if (ints[0] != t1[0]) {
                    return ints[0] - t1[0];
                } else {
                    return ints[1] - t1[1];
                }
            }
        });

        for (int[] p : power) {
            priorityQueue.offer(p);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[1];
        }

        return ans;
    }

}

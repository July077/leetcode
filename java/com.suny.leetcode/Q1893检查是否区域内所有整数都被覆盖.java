import java.util.Arrays;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * <p>
 * 给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]表示一个从starti到endi的闭区间。
 * <p>
 * 如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。
 * <p>
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi，那么我们称整数x被覆盖了。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-23 9:24
 */
public class Q1893检查是否区域内所有整数都被覆盖 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2) -> o1[0] - o2[0]);

        for (int[] range : ranges) {
            int l = range[0];
            int r = range[1];
            if (l <= left && left <= r) {
                left = r + 1;
            }
        }

        return left > right;
    }


    // 暴力破解
    public boolean isCovered0(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                flag[i] = true;
            }
        }

        for (int i = left; i <= right; i++) {
            if (!flag[i]) {
                return false;
            }

        }

        return true;


    }
}

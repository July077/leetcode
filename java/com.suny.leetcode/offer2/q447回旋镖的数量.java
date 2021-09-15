package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * <p>
 * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/13 上午9:05
 */
public class q447回旋镖的数量 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] point : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] ints : points) {
                int dx = point[0] - ints[0];
                int dy = point[1] - ints[1];
                int dis = dx * dx + dy * dy;
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (Integer value : map.values()) {
                res += value * (value - 1);
            }
        }

        return res;
    }

}

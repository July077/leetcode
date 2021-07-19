/**
 * 149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 * @author sunjianrong
 * @date 2021/7/18 上午9:27
 */
public class Q149直线上最多的点数 {
    public int maxPoints(int[][] points) {
        int res = 1;
        for (int i = 0; i < points.length; i++) {
            int[] m = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - m[0];
                int dy = points[j][1] - m[1];
                int count = 0;
                int d = dx * m[1] - dy * m[0];

                for (int[] point : points) {
                    if (dx * point[1] == dy * point[0] + d) {
                        ++count;
                    }
                }

                res = Math.max(res, count);

            }
        }

        return res;

    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1610. 可见点的最大数目
 * <p>
 * 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
 * <p>
 * 最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
 * <p>
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021-12-16 9:27
 */
public class Q1610可见点的最大数目 {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0);
        int y = location.get(1);

        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI;
        double t = angle * pi / 180;
        for (List<Integer> point : points) {
            int a = point.get(0);
            final Integer b = point.get(1);
            if (a == x && b == y && ++cnt >= 0) {
                continue;
            }
            list.add(Math.atan2(b - y, a - x));
        }

        Collections.sort(list);
        int n = list.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            list.add(list.get(i) + 2 * pi);
        }

        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t) {
                i++;
            }

            max = Math.max(max, j - i + 1);

        }
        return cnt + max;
    }
}

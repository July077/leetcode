/**
 * 335. 路径交叉
 * 给你一个整数数组 distance 。
 * <p>
 * 从 X-Y 平面上的点(0,0)开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * <p>
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-29 9:30
 */
public class Q335路径交叉 {

    public boolean isSelfCrossing(int[] distance) {
        final int length = distance.length;

        int i = 0;
        while (i < length && (i < 2 || distance[i] > distance[i - 2])) {
            ++i;
        }

        if (i == length) {
            return false;
        }

        // 处理 j 次移动
        if ((i == 3 && distance[i] == distance[i - 2]) || (i >= 4 && distance[i] >= distance[i - 2] - distance[i - 4])) {
            distance[i - 1] -= distance[i - 3];
        }

        ++i;

        while (i < length && distance[i] < distance[i - 2]) {
            ++i;
        }

        return i != length;

    }
}

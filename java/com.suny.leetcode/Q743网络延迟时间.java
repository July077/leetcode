import java.util.Arrays;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为1到 n。
 * <p>
 * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
 * <p>
 *
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-02 9:19
 */
public class Q743网络延迟时间 {

    public int networkDelayTime(int[][] times, int n, int k) {
        final int inf = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], inf);
        }

        for (int[] time : times) {
            int x = time[0] - 1;
            int y = time[1] - 1;
            g[x][y] = time[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, inf);
        dist[k - 1] = 0;

        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int j = 0; j < n; ++j) {
                if (!used[j] && (x == -1 || dist[j] < dist[x])) {
                    x = j;
                }
            }

            used[x] = true;

            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[x] + g[x][j]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == inf ? -1 : ans;

    }

}

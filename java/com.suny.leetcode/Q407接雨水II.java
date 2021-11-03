import java.util.PriorityQueue;

/**
 * 407. 接雨水 II
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-03 9:22
 */
public class Q407接雨水II {


    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }

        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] vis = new boolean[n][m];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);


        // 放最外一圈
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    priorityQueue.offer(new int[]{i, j, heightMap[i][j]});
                    vis[i][j] = true;
                }
            }
        }

        int res = 0;
        // 方向数组，把 dx跟dy压缩成一维来做
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!priorityQueue.isEmpty()) {
            final int[] poll = priorityQueue.poll();
            // 没访问过就不灌水
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dirs[i];
                int ny = poll[1] + dirs[i + 1];
                // 如果位置合法并且没有访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // 如果外围的最早的比这高，就说明可以往里面灌水
                    if (poll[2] > heightMap[nx][ny]) {
                        res += poll[2] - heightMap[nx][ny];
                    }
                    // 如果灌水高度就是灌水后的高度了，没灌水也要取最高的
                    priorityQueue.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], poll[2])});
                    vis[nx][ny] = true;
                }
            }
        }

        return res;

    }
}

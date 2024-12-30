import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3342 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int INF = (int) 1e9 + 2000;

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        // x,y,step,dist
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        pq.add(new int[]{0, 0, 0, 0});
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int cx = top[0], cy = top[1], step = top[2];
            if (vis[cx][cy]) continue;
            vis[cx][cy] = true;

            for (int[] d : DIRECTIONS) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                int nstep = step % 2 == 0 ? 1 : 2;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && dist[nx][ny] > Math.max(dist[cx][cy], moveTime[nx][ny]) + nstep) {
                    dist[nx][ny] = Math.max(dist[cx][cy], moveTime[nx][ny]) + nstep;
                    pq.add(new int[]{nx, ny, step + 1, dist[nx][ny]});
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}
/*
3342. 到达最后一个房间的最少时间 II
https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-ii/description/

第 422 场周赛 T3。

有一个地窖，地窖中有 n x m 个房间，它们呈网格状排布。
给你一个大小为 n x m 的二维数组 moveTime ，其中 moveTime[i][j] 表示在这个时刻 以后 你才可以 开始 往这个房间 移动 。你在时刻 t = 0 时从房间 (0, 0) 出发，每次可以移动到 相邻 的一个房间。在 相邻 房间之间移动需要的时间为：第一次花费 1 秒，第二次花费 2 秒，第三次花费 1 秒，第四次花费 2 秒……如此 往复 。
请你返回到达房间 (n - 1, m - 1) 所需要的 最少 时间。
如果两个房间有一条公共边（可以是水平的也可以是竖直的），那么我们称这两个房间是 相邻 的。
提示：
2 <= n == moveTime.length <= 750
2 <= m == moveTime[i].length <= 750
0 <= moveTime[i][j] <= 10^9

BFS 也可以 AC。为了保险起见，改为 dijkstra，，
 */
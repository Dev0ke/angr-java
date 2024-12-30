import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution3341 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        q.add(new int[]{0, 0});
        vis[0][0] = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] p = q.remove();
                int cx = p[0], cy = p[1];
                for (int[] d : DIRECTIONS) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m
                            && vis[nx][ny] > Math.max(vis[cx][cy], moveTime[nx][ny]) + 1) {
                        vis[nx][ny] = Math.max(vis[cx][cy], moveTime[nx][ny]) + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return vis[n - 1][m - 1];
    }
}
/*
3341. 到达最后一个房间的最少时间 I
https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-i/description/

第 422 场周赛 T2。

有一个地窖，地窖中有 n x m 个房间，它们呈网格状排布。
给你一个大小为 n x m 的二维数组 moveTime ，其中 moveTime[i][j] 表示在这个时刻 以后 你才可以 开始 往这个房间 移动 。你在时刻 t = 0 时从房间 (0, 0) 出发，每次可以移动到 相邻 的一个房间。在 相邻 房间之间移动需要的时间为 1 秒。
请你返回到达房间 (n - 1, m - 1) 所需要的 最少 时间。
如果两个房间有一条公共边（可以是水平的也可以是竖直的），那么我们称这两个房间是 相邻 的。
提示：
2 <= n == moveTime.length <= 50
2 <= m == moveTime[i].length <= 50
0 <= moveTime[i][j] <= 10^9

BFS 即可。
 */
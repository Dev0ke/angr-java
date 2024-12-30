import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Solution3286 {
    static class V1 {
        private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public boolean findSafeWalk(List<List<Integer>> grid, int health) {
            int m = grid.size();
            int n = grid.get(0).size();
            if (grid.get(0).get(0).equals(1)) health--;
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0, 0, health});
            int[][] vis = new int[m][n];
            vis[0][0] = health;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] top = q.remove();
                    int cx = top[0], cy = top[1], chealth = top[2];
                    if (cx == m - 1 && cy == n - 1 && chealth > 0) return true;

                    for (int[] d : DIRECTIONS) {
                        int nx = cx + d[0];
                        int ny = cy + d[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            Integer v = grid.get(nx).get(ny);
                            if (chealth - v > vis[nx][ny]) {
                                vis[nx][ny] = chealth - v;
                                q.add(new int[]{nx, ny, chealth - v});
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    // 0-1 BFS
    static class V2 {
        private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public boolean findSafeWalk(List<List<Integer>> grid, int health) {
            int m = grid.size();
            int n = grid.get(0).size();

            int[][] dist = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = grid.get(0).get(0);
            Deque<int[]> dq = new ArrayDeque<>();
            dq.addFirst(new int[]{0, 0});
            while (!dq.isEmpty()) {
                int[] p = dq.pollFirst();
                int cx = p[0], cy = p[1];
                for (int[] d : DIRECTIONS) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                        int cost = grid.get(nx).get(ny);
                        if (dist[nx][ny] > dist[cx][cy] + cost) {
                            dist[nx][ny] = dist[cx][cy] + cost;
                            if (cost == 0) {
                                dq.addFirst(new int[]{nx, ny});
                            } else {
                                dq.addLast(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            return dist[m - 1][n - 1] < health;
        }
    }
}
/*
3286. 穿越网格图的安全路径
https://leetcode.cn/problems/find-a-safe-walk-through-a-grid/description/

第 139 场双周赛 T2。

给你一个 m x n 的二进制矩形 grid 和一个整数 health 表示你的健康值。
你开始于矩形的左上角 (0, 0) ，你的目标是矩形的右下角 (m - 1, n - 1) 。
你可以在矩形中往上下左右相邻格子移动，但前提是你的健康值始终是 正数 。
对于格子 (i, j) ，如果 grid[i][j] = 1 ，那么这个格子视为 不安全 的，会使你的健康值减少 1 。
如果你可以到达最终的格子，请你返回 true ，否则返回 false 。
注意 ，当你在最终格子的时候，你的健康值也必须为 正数 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
2 <= m * n
1 <= health <= m + n
grid[i][j] 要么是 0 ，要么是 1 。

BFS。
时间复杂度 O(mn(m+n))。
一个节点可能会入队多次。可以用 0-1 BFS 优化至 O(mn)。
 */
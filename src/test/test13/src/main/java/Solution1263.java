import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class Solution1263 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sx = 0, sy = 0, bx = 0, by = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx * n + sy, bx * n + by});
        int[][] dist = new int[m * n][m * n];
        for (int i = 0; i < m * n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[sx * n + sy][bx * n + by] = 0;

        while (!dq.isEmpty()) {
            int[] p = dq.removeFirst();
            int s1 = p[0], b1 = p[1];
            int sx1 = s1 / n, sy1 = s1 % n;
            int bx1 = b1 / n, by1 = b1 % n;
            // 箱子已被推到目标处
            if (grid[bx1][by1] == 'T') return dist[s1][b1];
            for (int[] dir : DIRECTIONS) {
                int sx2 = sx1 + dir[0], sy2 = sy1 + dir[1], s2 = sx2 * n + sy2;
                // 玩家位置不合法
                if (notOk(grid, sx2, sy2)) continue;
                // 推动箱子
                if (sx2 == bx1 && sy2 == by1) {
                    int bx2 = bx1 + dir[0], by2 = by1 + dir[1], b2 = bx2 * n + by2;
                    // 箱子位置不合法 或 状态已访问
                    if (notOk(grid, bx2, by2) || dist[s2][b2] <= dist[s1][b1] + 1) continue;
                    dist[s2][b2] = dist[s1][b1] + 1;
                    dq.addLast(new int[]{s2, b2});
                } else {
                    // 状态已访问
                    if (dist[s2][b1] <= dist[s1][b1]) continue;
                    dist[s2][b1] = dist[s1][b1];
                    dq.addFirst(new int[]{s2, b1});
                }
            }
        }
        return -1;
    }

    private boolean notOk(char[][] grid, int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '#';
    }
}
/*
1263. 推箱子
https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/

「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
游戏地图用大小为 m x n 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：
- 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
- 地板用字符 '.' 表示，意味着可以自由行走。
- 墙用字符 '#' 表示，意味着障碍物，不能通行。
- 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
- 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
- 玩家无法越过箱子。
返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid 仅包含字符 '.', '#',  'S' , 'T', 以及 'B'。
grid 中 'S', 'B' 和 'T' 各只能出现一个。

0-1 BFS
时间复杂度 O(m^2 * n*2)
空间复杂度 O(m^2 * n*2)
 */
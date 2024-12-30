import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1091 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        // m n step
        queue.add(new int[]{0, 0, 1});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int cx = tuple[0], cy = tuple[1], cstep = tuple[2];
            if (cx == m - 1 && cy == n - 1) {
                return cstep;
            }

            for (int[] dir : DIRECTIONS8) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                int nstep = cstep + 1;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && grid[nx][ny] == 0 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.add(new int[]{nx, ny, nstep});
                }
            }
        }
        // 如果不存在这样的路径，返回 -1 。
        return -1;
    }
}
/*
1091. 二进制矩阵中的最短路径
https://leetcode.cn/problems/shortest-path-in-binary-matrix/

第 141 场周赛 T3。

给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
- 路径途经的所有单元格都的值都是 0 。
- 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
畅通路径的长度 是该路径途经的单元格总数。
提示：
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] 为 0 或 1

BFS。
 */
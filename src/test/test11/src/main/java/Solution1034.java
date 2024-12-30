import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1034 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;

        int originColor = grid[row][col];
        // BFS
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        queue.add(new int[]{row, col});
        vis[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                // 连通分量的边界
                int cx = tuple[0];
                int cy = tuple[1];
                if (grid[cx][cy] == originColor
                        && (cx == 0 || cy == 0 || cx == m - 1 || cy == n - 1)) {
                    grid[cx][cy] = color;
                }

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                        // 连通分量的边界
                        if (grid[nx][ny] != originColor) {
                            grid[cx][cy] = color;
                        }
                        if (grid[nx][ny] == originColor) {
                            vis[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return grid;
    }
}
/*
1034. 边界着色
https://leetcode.cn/problems/coloring-a-border/

第 134 场周赛 T2。

给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数  row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
- 两个网格块属于同一 连通分量 需满足下述全部条件：
- 两个网格块颜色相同
在上、下、左、右任意一个方向上相邻
连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
- 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
- 在网格的边界上（第一行/列或最后一行/列）
请你使用指定颜色  color 为所有包含网格块  grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格  grid 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j], color <= 1000
0 <= row < m
0 <= col < n

按要求BFS。
 */
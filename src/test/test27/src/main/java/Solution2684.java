import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution2684 {
    // BFS
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0});
            vis[i][0] = true;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1];
                res = Math.max(res, cy);

                for (int j = -1; j <= 1; j++) {
                    int nx = cx + j;
                    int ny = cy + 1;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]
                            && grid[nx][ny] > grid[cx][cy]) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return res;
    }

    // DFS
    private int[][] grid;
    private int m, n;
    private int[][] memo;

    public int maxMoves2(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        // 记忆化搜索
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dfs(i, 0));
        }
        return res;
    }

    private int dfs(int x, int y) {
        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        int res = 0;
        int ny = y + 1;
        if (ny < n) {
            for (int nx = Math.max(0, x - 1); nx <= Math.min(m - 1, x + 1); nx++) {
                if (grid[nx][ny] > grid[x][y]) {
                    res = Math.max(res, dfs(nx, ny) + 1);
                }
            }
        }
        memo[x][y] = res;
        return res;
    }
}
/*
2684. 矩阵中移动的最大次数
https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/

第 345 场周赛 T3。

给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
- 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
返回你在矩阵中能够 移动 的 最大 次数。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 10^5
1 <= grid[i][j] <= 10^6

BFS / DFS
时间复杂度 O(mn)
 */
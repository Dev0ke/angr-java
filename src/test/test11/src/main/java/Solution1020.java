public class Solution1020 {
    private int M;
    private int N;

    public int numEnclaves(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;

        // “水淹” 所有边缘的 陆地
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if ((i == 0 || i == M - 1 || j == 0 || j == N - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i >= 0 && i < M && j >= 0 && j < N && grid[i][j] == 1) {
            grid[i][j] = 0;
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }
}
/*
1020. 飞地的数量
https://leetcode.cn/problems/number-of-enclaves/

给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] 的值为 0 或 1

思路同 Solution1254，先将与矩阵边缘联通的 1 全部转成 0，本题数据量大于 Solution1254，BFS 会超时，DFS 可以 AC
相似题目: 1254. 统计封闭岛屿的数目
https://leetcode.cn/problems/number-of-closed-islands/
 */
public class Solution2556 {
    private int[][] grid;
    private int m;
    private int n;

    public boolean isPossibleToCutPath(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        if (!dfs(0, 0)) {
            return true;
        }
        return !dfs(0, 0);
    }

    private boolean dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        grid[x][y] = 0;
        return x + 1 < m && grid[x + 1][y] > 0 && dfs(x + 1, y)
                || y + 1 < n && grid[x][y + 1] > 0 && dfs(x, y + 1);
    }
}
/*
2556. 二进制矩阵中翻转最多一次使路径不连通
https://leetcode.cn/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/

第 97 场双周赛 T4。

给你一个下标从 0 开始的 m x n 二进制 矩阵 grid 。你可以从一个格子 (row, col) 移动到格子 (row + 1, col) 或者 (row, col + 1) ，
前提是前往的格子值为 1 。如果从 (0, 0) 到 (m - 1, n - 1) 没有任何路径，我们称该矩阵是 不连通 的。
你可以翻转 最多一个 格子的值（也可以不翻转）。你 不能翻转 格子 (0, 0) 和 (m - 1, n - 1) 。
如果可以使矩阵不连通，请你返回 true ，否则返回 false 。
注意 ，翻转一个格子的值，可以使它的值从 0 变 1 ，或从 1 变 0 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
grid[0][0] == grid[m - 1][n - 1] == 1

如果存在 下轮廓 + 另外一条任意路径，则无法通过一次翻转使路径不连通
时间复杂度 O(mn)
 */
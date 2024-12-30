public class Solution840 {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 1; i + 1 < m; i++) {
            for (int j = 1; j + 1 < n; j++) {
                if (grid[i][j] != 5) continue;
                int[] a = {
                        grid[i - 1][j - 1], grid[i - 1][j], grid[i - 1][j + 1],
                        grid[i][j - 1], grid[i][j], grid[i][j + 1],
                        grid[i + 1][j - 1], grid[i + 1][j], grid[i + 1][j + 1]
                };
                if (magic(a)) ans++;
            }
        }
        return ans;
    }

    private boolean magic(int[] a) {
        for (int i = 0; i < 9; i++) {
            // 除矩阵中心外不能有 5（9 个 5 的用例）
            if (a[i] == 5 && i != 4) return false;
            if (a[i] < 1 || a[i] > 9) return false;
        }
        boolean rowEq = a[0] + a[1] + a[2] == 15
                && a[3] + a[4] + a[5] == 15
                && a[6] + a[7] + a[8] == 15;
        boolean colEq = a[0] + a[3] + a[6] == 15
                && a[1] + a[4] + a[7] == 15
                && a[2] + a[5] + a[8] == 15;
        return (rowEq && colEq
                && a[0] + a[4] + a[8] == 15
                && a[2] + a[4] + a[6] == 15);
    }
}
/*
840. 矩阵中的幻方
https://leetcode.cn/problems/magic-squares-in-grid/

第 86 场周赛 T1。

3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
提示:
row == grid.length
col == grid[i].length
1 <= row, col <= 10
0 <= grid[i][j] <= 15

易通过数学知识得知 矩阵中心点 数值为 5，需注意剔除不满足的题意用例
 */
public class Solution3239 {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 所有行是 回文的
        int ans_row = 0;
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                if (grid[i][l] != grid[i][r]) cnt++;
            }
            ans_row += cnt;
        }
        // 所有列是 回文的
        int ans_col = 0;
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int l = 0, r = m - 1; l < r; l++, r--) {
                if (grid[l][j] != grid[r][j]) cnt++;
            }
            ans_col += cnt;
        }
        return Math.min(ans_row, ans_col);
    }
}
/*
3239. 最少翻转次数使二进制矩阵回文 I
https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/description/

第 136 场双周赛 T2。

给你一个 m x n 的二进制矩阵 grid 。
如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
提示：
m == grid.length
n == grid[i].length
1 <= m * n <= 2 * 10^5
0 <= grid[i][j] <= 1

贪心。两种情况：
1、所有行是 回文的
2、所有列是 回文的
看哪种翻转次数少。
时间复杂度 O(mn)。
 */
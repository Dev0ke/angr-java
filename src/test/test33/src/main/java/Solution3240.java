public class Solution3240 {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        // 必为 4 倍数
        int half_m = m / 2, half_n = n / 2;
        for (int i = 0; i < half_m; i++) {
            for (int j = 0; j < half_n; j++) {
                int a = grid[i][j];
                int b = grid[i][n - 1 - j];
                int c = grid[m - 1 - i][j];
                int d = grid[m - 1 - i][n - 1 - j];
                int s = a + b + c + d;
                ans += Math.min(s, 4 - s);
            }
        }
        // 中心点
        if (m % 2 == 1 && n % 2 == 1 && grid[half_m][half_n] == 1) {
            ans++;
        }

        // 重点讨论：
        int cnt_same_1 = 0; // 相同的 1（每对 11 贡献 2）
        int cnt_diff_1 = 0; // 不同的 1（每对 10/01 贡献 1）
        if (m % 2 == 1) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                if (grid[half_m][l] != grid[half_m][r]) {
                    cnt_diff_1 += 1;
                } else {
                    if (grid[half_m][l] == 1) {
                        cnt_same_1 += 2;
                    }
                }
            }
        }
        if (n % 2 == 1) {
            for (int l = 0, r = m - 1; l < r; l++, r--) {
                if (grid[l][half_n] != grid[r][half_n]) {
                    cnt_diff_1 += 1;
                } else {
                    if (grid[l][half_n] == 1) {
                        cnt_same_1 += 2;
                    }
                }
            }
        }
        cnt_same_1 %= 4;
        // 根据 cnt_same_1 的情况（0 或 2），看 cnt_diff_1 变 11 还是 00
        // cnt_same_1 = 0, cnt_diff_1 变全 0
        // cnt_same_1 = 2, 只要 cnt_diff_1 > 0, 就可以凑出一个 2
        if (cnt_same_1 == 2 && cnt_diff_1 == 0) {
            ans += 2;
        }
        return ans + cnt_diff_1;
    }
}
/*
3240. 最少翻转次数使二进制矩阵回文 II
https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-ii/description/

第 136 场双周赛 T3。

给你一个 m x n 的二进制矩阵 grid 。
如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
请你返回 最少 翻转次数，使得矩阵中 所有 行和列都是 回文的 ，且矩阵中 1 的数目可以被 4 整除 。
提示：
m == grid.length
n == grid[i].length
1 <= m * n <= 2 * 10^5
0 <= grid[i][j] <= 1

分类讨论。
时间复杂度 O(mn)。
 */
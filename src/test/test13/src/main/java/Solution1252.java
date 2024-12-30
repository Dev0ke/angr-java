public class Solution1252 {
    // O(m * n + q)
    public int oddCells(int m, int n, int[][] indices) {
        int[] cnt_row = new int[m];
        int[] cnt_col = new int[n];
        for (int[] p : indices) {
            cnt_row[p[0]]++;
            cnt_col[p[1]]++;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((cnt_row[i] + cnt_col[j]) % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 计数优化 O(m + n + q)
    public int oddCells2(int m, int n, int[][] indices) {
        int[] cnt_row = new int[m];
        int[] cnt_col = new int[n];
        for (int[] p : indices) {
            cnt_row[p[0]]++;
            cnt_col[p[1]]++;
        }

        int oddx = 0, oddy = 0;
        for (int i = 0; i < m; i++) {
            if ((cnt_row[i] & 1) != 0) {
                oddx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((cnt_col[i] & 1) != 0) {
                oddy++;
            }
        }
        return oddx * (n - oddy) + (m - oddx) * oddy;
    }
}
/*
1252. 奇数值单元格的数目
https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/description/

给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
1. ri 行上的所有单元格，加 1 。
2. ci 列上的所有单元格，加 1 。
给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
提示：
1 <= m, n <= 50
1 <= indices.length <= 100
0 <= ri < m
0 <= ci < n
进阶：你可以设计一个时间复杂度为 O(n + m + indices.length) 且仅用 O(n + m) 额外空间的算法来解决此问题吗？

计数。
时间复杂度 O(m*n + q)。
 */
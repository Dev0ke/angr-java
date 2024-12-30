public class Solution1895 {
    private int[][] row_sum, col_sum, diag_sum, anti_diag_sum;

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        row_sum = new int[n + 1][m + 1];
        col_sum = new int[n + 1][m + 1];
        diag_sum = new int[n + 1][m + 1];
        anti_diag_sum = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                row_sum[i][j + 1] = row_sum[i][j] + v;
                col_sum[i + 1][j] = col_sum[i][j] + v;
                diag_sum[i + 1][j + 1] = diag_sum[i][j] + v;
                anti_diag_sum[i + 1][j] = anti_diag_sum[i][j + 1] + v;
            }
        }

        for (int k = Math.min(n, m); ; k--) {
            for (int r = k; r <= n; r++) {
                for (int c = k; c <= m; c++) {
                    if (check(r, c, k)) {
                        return k;
                    }
                }
            }
        }
    }

    private boolean check(int r, int c, int k) {
        int sum = diag_sum[r][c] - diag_sum[r - k][c - k];
        if (anti_diag_sum[r][c - k] - anti_diag_sum[r - k][c] != sum) return false;
        for (int i = r - k; i < r; i++) {
            if (row_sum[i][c] - row_sum[i][c - k] != sum) return false;
        }
        for (int j = c - k; j < c; j++) {
            if (col_sum[r][j] - col_sum[r - k][j] != sum) return false;
        }
        return true;
    }
}
/*
1895. 最大的幻方
https://leetcode.cn/problems/largest-magic-square/description/

一个 k x k 的 幻方 指的是一个 k x k 填满整数的方格阵，且每一行、每一列以及两条对角线的和 全部相等 。幻方中的整数 不需要互不相同 。显然，每个 1 x 1 的方格都是一个幻方。
给你一个 m x n 的整数矩阵 grid ，请你返回矩阵中 最大幻方 的 尺寸 （即边长 k）。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j] <= 10^6

前缀和。
时间复杂度 $O(n \times m \times k^2)$。其中 $k = min(n, m)$。
https://leetcode.cn/problems/largest-magic-square/solutions/825422/go-qian-zhui-he-by-endlesscheng-59wj/
 */
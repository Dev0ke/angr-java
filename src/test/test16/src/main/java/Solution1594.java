public class Solution1594 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // f[i][j], g[i][j] 分别为从坐标 (0,0) 出发，到达位置 (i,j) 时乘积的最大值与最小值
        long[][] f = new long[m][n];
        long[][] g = new long[m][n];
        f[0][0] = g[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            f[0][i] = g[0][i] = f[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            f[i][0] = g[i][0] = f[i - 1][0] * grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) * grid[i][j];
                    g[i][j] = Math.min(g[i][j - 1], g[i - 1][j]) * grid[i][j];
                } else {
                    f[i][j] = Math.min(g[i][j - 1], g[i - 1][j]) * grid[i][j];
                    g[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) * grid[i][j];
                }
            }
        }
        return f[m - 1][n - 1] < 0 ? -1 : (int) (f[m - 1][n - 1] % MOD);
    }
}
/*
1594. 矩阵的最大非负积
https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/description/

给你一个大小为 m x n 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
返回 最大非负积 对 10^9 + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。
注意，取余是在得到最大积之后执行的。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 15
-4 <= grid[i][j] <= 4

动态规划。
时间复杂度 O(mn)。
相似题目: 152. 乘积最大子数组
https://leetcode.cn/problems/maximum-product-subarray/
 */
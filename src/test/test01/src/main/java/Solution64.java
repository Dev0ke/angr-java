public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // f[i][j] 表示到达 grid[i][j] 矩阵的最小路径和
        int[][] f = new int[m][n];

        // 初始状态 第一行 + 第一列
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
/*
64. 最小路径和
https://leetcode.cn/problems/minimum-path-sum/

给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
每次只能向下或者向右移动一步。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100

动态规划。
定义 dp[i][j] 为 i x j 矩阵中，路径上的数字总和为最小的值。
相似题目: 剑指 Offer 47. 礼物的最大价值
https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
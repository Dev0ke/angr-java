public class Solution2435 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][_k] 表示从坐标 (0,0) 到坐标 (i,j) 的路径和 %k 余数为 _k 的总数
        int[][][] dp = new int[m][n][k];
        // 初始状态
        dp[0][0][grid[0][0] % k] = 1;
        // 状态转移
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int _k = 0; _k < k; _k++) {
                    if (j - 1 >= 0 && dp[i][j - 1][_k] > 0) {
                        int _k1 = (_k + grid[i][j]) % k;
                        dp[i][j][_k1] = (dp[i][j][_k1] + dp[i][j - 1][_k]) % MOD;
                    }
                    if (i - 1 >= 0 && dp[i - 1][j][_k] > 0) {
                        int _k1 = (_k + grid[i][j]) % k;
                        dp[i][j][_k1] = (dp[i][j][_k1] + dp[i - 1][j][_k]) % MOD;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}
/*
2435. 矩阵中和能被 K 整除的路径
https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k/

第 314 场周赛 T4。

给你一个下标从 0 开始的 m x n 整数矩阵 grid 和一个整数 k 。你从起点 (0, 0) 出发，每一步只能往 下 或者往 右 ，你想要到达终点 (m - 1, n - 1) 。
请你返回路径和能被 k 整除的路径数目，由于答案可能很大，返回答案对 10^9 + 7 取余 的结果。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 5 * 10^4
1 <= m * n <= 5 * 10^4
0 <= grid[i][j] <= 100
1 <= k <= 50

动态规划。
相似题目: 62. 不同路径
https://leetcode.cn/problems/unique-paths/
 */
public class Solution62 {
    /**
     * 组合数学
     * 时间复杂度 O(m)
     * 空间复杂度 O(1)
     */
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    /**
     * 动态规划
     * 时间复杂度 O(mn)
     * 空间复杂度 O(mn)
     */
    public int uniquePaths2(int m, int n) {
        // f[i][j] 表示到达坐标 (i,j) 的不同路径数
        int[][] f = new int[m][n];
        // 初始状态
        f[0][0] = 1;
        for (int i = 1; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = 1;
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
/*
62. 不同路径
https://leetcode.cn/problems/unique-paths/

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？
提示：
1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10^9

组合数学
从左上角到右下角的过程中，我们需要移动 m+n−2 次，其中有 m−1 次向下移动，n−1 次向右移动。
因此路径的总数，就等于从 m+n−2 次移动中选择 m−1 次向下移动的方案数，即组合数：
  m-1
C
  m+n−2
动态规划:
输入：m = 3, n = 7
输出：28
定义 dp[i][j] 来表示从坐标 (0,0) 到坐标 (i,j) 的路径总数
初始状态:
1 1 1 1 1 1 1
1 0 0 0 0 0 0
1 0 0 0 0 0 0
转移方程:
dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
1  1  1  1  1  1  1
1  2  3  4  5  6  7
1  3  6 10 15 21 28
结果 dp[m][n] = 28
相似题目: 63. 不同路径 II
https://leetcode.cn/problems/unique-paths-ii/
 */
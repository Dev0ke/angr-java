public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int matM = matrix.length;
        int matN = matrix[0].length;

        int max = 0;
        // 状态定义
        // dp[i][j] 表示以 [i,j] 为右下角，只包含 1 的正方形的边长的最大值
        int[][] dp = new int[matM][matN];
        // 状态转移
        for (int i = 0; i < matM; i++) {
            for (int j = 0; j < matN; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
/*
221. 最大正方形
https://leetcode.cn/problems/maximal-square/

在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] 为 '0' 或 '1'

动态规划。
dp[i][j] 表示以 [i,j] 为右下角，只包含 1 的正方形的边长的最大值
转移方程：
dp(i,j) = min(dp(i−1,j), dp(i−1,j−1), dp(i,j−1)) + 1
相似题目: 1277. 统计全为 1 的正方形子矩阵
https://leetcode.cn/problems/count-square-submatrices-with-all-ones/
 */
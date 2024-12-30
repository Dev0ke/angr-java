public class Solution1277 {
    public int countSquares(int[][] matrix) {
        int matM = matrix.length;
        int matN = matrix[0].length;

        int cnt = 0;
        // 状态定义
        // dp[i][j] 表示以 [i,j] 为右下角，只包含 1 的正方形的边长的最大值
        int[][] dp = new int[matM][matN];
        // 状态转移
        for (int i = 0; i < matM; i++) {
            for (int j = 0; j < matN; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    cnt+= dp[i][j];
                }
            }
        }
        return cnt;
    }
}
/*
1277. 统计全为 1 的正方形子矩阵
https://leetcode.cn/problems/count-square-submatrices-with-all-ones/

第 165 场周赛 T3。

给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
提示：
1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

动态规划。
dp[i][j] 表示以 [i,j] 为右下角，只包含 1 的正方形的边长的最大值
转移方程：
dp(i,j) = min(dp(i−1,j), dp(i−1,j−1), dp(i,j−1)) + 1
相似题目: 221. 最大正方形
https://leetcode.cn/problems/maximal-square/
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 这些数必然落在区间 [1,√n]
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
/*
279. 完全平方数
https://leetcode.cn/problems/perfect-squares/

给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
提示：
1 <= n <= 10^4

动态规划（或四平方和定理）
dp[i] 表示最少需要多少个数的平方来表示整数 i
时间复杂度 O(n√n)
空间复杂度 O(n)
 */
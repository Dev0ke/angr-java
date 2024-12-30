public class Solution2312 {
    public long sellingWood(int m, int n, int[][] prices) {
        // dp[i][j] 表示高 i 宽 j 矩形木块 能得到的 最多 钱数
        long[][] dp = new long[m + 1][n + 1];

        // 初始状态
        for (int[] price : prices) {
            dp[price[0]][price[1]] = price[2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }
        return dp[m][n];
    }
}
/*
2312. 卖木头块
https://leetcode.cn/problems/selling-pieces-of-wood/

第 298 场周赛 T4。

给你两个整数 m 和 n ，分别表示一块矩形木块的高和宽。同时给你一个二维整数数组 prices ，
其中 prices[i] = [hi, wi, pricei] 表示你可以以 pricei 元的价格卖一块高为 hi 宽为 wi 的矩形木块。
每一次操作中，你必须按下述方式之一执行切割操作，以得到两块更小的矩形木块：
- 沿垂直方向按高度 完全 切割木块，或
- 沿水平方向按宽度 完全 切割木块
在将一块木块切成若干小木块后，你可以根据 prices 卖木块。你可以卖多块同样尺寸的木块。你不需要将所有小木块都卖出去。你 不能 旋转切好后木块的高和宽。
请你返回切割一块大小为 m x n 的木块后，能得到的 最多 钱数。
注意你可以切割木块任意次。
提示：
1 <= m, n <= 200
1 <= prices.length <= 2 * 10^4
prices[i].length == 3
1 <= hi <= m
1 <= wi <= n
1 <= pricei <= 10^6
所有 (hi, wi) 互不相同 。
 */
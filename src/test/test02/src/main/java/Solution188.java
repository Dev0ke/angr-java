public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        // 因为 n 天最多只能进行 floor(len/2) 笔交易
        k = Math.min(k, len / 2);

        // buy[i][j] 表示对于数组 prices[0,i] 中的价格而言，进行恰好 j 笔交易，并且当前手上持有一支股票，这种情况下的最大利润
        // sell[i][j] 表示恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润
        int[][] buy = new int[len][k + 1];
        int[][] sell = new int[len][k + 1];

        // 初始状态
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        // 状态转移
        for (int i = 1; i < len; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        int max = 0;
        for (int x : sell[len - 1]) {
            max = Math.max(max, x);
        }
        return max;
    }
}
/*
188. 买卖股票的最佳时机 IV
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/

给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
提示：
0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000

动态规划
 */
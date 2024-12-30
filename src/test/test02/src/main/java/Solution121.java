public class Solution121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            // 到当日为止 历史最低价格
            min = Math.min(min, price);
            // max(当日价格减去 - 历史最低价格)
            max = Math.max(max, price - min);
        }
        return max;
    }
}
/*
121. 买卖股票的最佳时机
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/

给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
提示：
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4

动态规划。由于只能买入一次卖出一次，因此统计当日价格减去历史最低位的最大值即可。
 */

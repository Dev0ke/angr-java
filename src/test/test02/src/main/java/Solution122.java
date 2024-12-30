public class Solution122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // 贪心。累加所有差值为正数的交易
            res += Math.max(0, prices[i + 1] - prices[i]);
        }
        return res;
    }
}
/*
122. 买卖股票的最佳时机 II
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/

给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
返回 你能获得的 最大 利润 。
提示：
1 <= prices.length <= 3 * 10^4
0 <= prices[i] <= 10^4

贪心。只要明天比今天涨的都进行交易。
系列题解 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 */

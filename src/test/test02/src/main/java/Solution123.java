public class Solution123 {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sell1 = 0;
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
/*
123. 买卖股票的最佳时机 III
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/

给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
提示：
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^5

动态规划
四种状态：
1.只进行过一次买操作
2.进行了一次买操作和一次卖操作，即完成了一笔交易
3.在完成了一笔交易的前提下，进行了第二次买操作
4.完成了全部两笔交易
时间复杂度 O(n)
空间复杂度 O(1)
 */
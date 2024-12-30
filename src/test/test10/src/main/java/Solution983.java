public class Solution983 {
    public int mincostTickets(int[] days, int[] costs) {
        int idx = 0;
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        for (int i = 1; i < lastDay + 1; i++) {
            if (i == days[idx]) {
                idx++;
                int d1 = i - 1;
                int d7 = Math.max(i - 7, 0);
                int d30 = Math.max(i - 30, 0);
                // "先上车后补票"
                int cost = Math.min(Math.min(dp[d1] + costs[0], dp[d7] + costs[1]), dp[d30] + costs[2]);
                dp[i] = cost;
            } else {
                // 当天不旅行就不买票
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }
}
/*
983. 最低票价
https://leetcode.cn/problems/minimum-cost-for-tickets/

第 121 场周赛 T3。

在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
火车票有三种不同的销售方式：
- 一张为期一天的通行证售价为 costs[0] 美元；
- 一张为期七天的通行证售价为 costs[1] 美元；
- 一张为期三十天的通行证售价为 costs[2] 美元。
通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
提示：
1 <= days.length <= 365
1 <= days[i] <= 365
days 按顺序严格递增
costs.length == 3
1 <= costs[i] <= 1000

动态规划。
 */
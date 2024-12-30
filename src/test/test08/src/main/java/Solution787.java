import java.util.Arrays;

public class Solution787 {
    private static final int INF = 100 * 10000 + 1;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // bellman ford 算法
        // 最多只能中转 k 次，即最多搭乘 k+1 次航班
        // dp[t][i] 表示通过恰好 t 次航班，从出发城市 src 到达城市 i 需要的最小花费。
        int[][] dp = new int[k + 2][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                dp[t][to] = Math.min(dp[t][to], dp[t - 1][from] + price);
            }
        }

        // 取 dp[1][dst], dp[2][dst], ... dp[k+1][dst] 最小值
        int min = INF;
        for (int t = 1; t <= k + 1; t++) {
            min = Math.min(min, dp[t][dst]);
        }
        return min == INF ? -1 : min;
    }
}
/*
787. K 站中转内最便宜的航班
https://leetcode.cn/problems/cheapest-flights-within-k-stops/

有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，
表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，
使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
提示：
1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 10^4
航班没有重复，且不存在自环
0 <= src, dst, k < n
src != dst

bellman ford 算法
相似题目: 1928. 规定时间内到达终点的最小花费
https://leetcode.cn/problems/minimum-cost-to-reach-destination-in-time/
 */
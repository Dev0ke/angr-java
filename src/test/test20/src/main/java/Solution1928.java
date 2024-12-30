import java.util.Arrays;

public class Solution1928 {
    private static final int INF = 1000 * 1000 + 1;

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        // bellman ford 算法
        // dp[t][i] 表示通过恰好 t 分钟到达城市 i 需要的最少通行费总和
        int[][] dp = new int[maxTime + 1][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }
        dp[0][0] = passingFees[0];
        for (int t = 1; t <= maxTime; t++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int cost = edge[2];
                if (cost <= t) {
                    // 双向通路
                    dp[t][to] = Math.min(dp[t][to], dp[t - cost][from] + passingFees[to]);
                    dp[t][from] = Math.min(dp[t][from], dp[t - cost][to] + passingFees[from]);
                }
            }
        }

        int min = INF;
        for (int t = 1; t <= maxTime; t++) {
            min = Math.min(min, dp[t][n - 1]);
        }
        return min == INF ? -1 : min;
    }
}
/*
1928. 规定时间内到达终点的最小花费
https://leetcode.cn/problems/minimum-cost-to-reach-destination-in-time/

第 56 场双周赛 T4。

一个国家有 n 个城市，城市编号为 0 到 n - 1 ，题目保证 所有城市 都由双向道路 连接在一起 。道路由二维整数数组 edges 表示，
其中 edges[i] = [xi, yi, timei] 表示城市 xi 和 yi 之间有一条双向道路，耗费时间为 timei 分钟。
两个城市之间可能会有多条耗费时间不同的道路，但是不会有道路两头连接着同一座城市。
每次经过一个城市时，你需要付通行费。通行费用一个长度为 n 且下标从 0 开始的整数数组 passingFees 表示，其中 passingFees[j] 是你经过城市 j 需要支付的费用。
一开始，你在城市 0 ，你想要在 maxTime 分钟以内 （包含 maxTime 分钟）到达城市 n - 1 。旅行的 费用 为你经过的所有城市 通行费之和 （包括 起点和终点城市的通行费）。
给你 maxTime，edges 和 passingFees ，请你返回完成旅行的 最小费用 ，如果无法在 maxTime 分钟以内完成旅行，请你返回 -1 。
提示：
1 <= maxTime <= 1000
n == passingFees.length
2 <= n <= 1000
n - 1 <= edges.length <= 1000
0 <= xi, yi <= n - 1
1 <= timei <= 1000
1 <= passingFees[j] <= 1000 
图中两个节点之间可能有多条路径。
图中不含有自环。

bellman ford 算法
相似题目: 787. K 站中转内最便宜的航班
https://leetcode.cn/problems/cheapest-flights-within-k-stops/
 */
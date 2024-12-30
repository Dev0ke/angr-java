import java.util.Arrays;

public class Solution2959 {
    private static final int INF = (int) 1e9;

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }
        for (int[] p : roads) {
            int u = p[0], v = p[1], wt = p[2];
            g[u][v] = Math.min(g[u][v], wt);
            g[v][u] = Math.min(g[v][u], wt);
        }

        int ans = 0;
        int[][] adj = new int[n][n];
        for (int mask = 0; mask < 1 << n; mask++) {
            // 重置 adj
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    System.arraycopy(g[i], 0, adj[i], 0, n);
                }
            }

            // Floyd
            for (int k = 0; k < n; k++) {
                if ((mask >> k & 1) == 0) continue;
                for (int i = 0; i < n; i++) {
                    if ((mask >> i & 1) == 0) continue;
                    for (int j = 0; j < n; j++) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }

            int maxD = 0;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 0) continue;
                for (int j = 0; j < n; j++) {
                    if ((mask >> j & 1) == 0) continue;
                    maxD = Math.max(maxD, adj[i][j]);
                }
            }
            if (maxD <= maxDistance) {
                ans++;
            }
        }
        return ans;
    }
}
/*
2959. 关闭分部的可行集合数目
https://leetcode.cn/problems/number-of-possible-sets-of-closing-branches/description/

第 119 场双周赛 T4。

一个公司在全国有 n 个分部，它们之间有的有道路连接。一开始，所有分部通过这些道路两两之间互相可以到达。
公司意识到在分部之间旅行花费了太多时间，所以它们决定关闭一些分部（也可能不关闭任何分部），同时保证剩下的分部之间两两互相可以到达且最远距离不超过 maxDistance 。
两个分部之间的 距离 是通过道路长度之和的 最小值 。
给你整数 n ，maxDistance 和下标从 0 开始的二维整数数组 roads ，其中 roads[i] = [ui, vi, wi] 表示一条从 ui 到 vi 长度为 wi的 无向 道路。
请你返回关闭分部的可行方案数目，满足每个方案里剩余分部之间的最远距离不超过 maxDistance。
注意，关闭一个分部后，与之相连的所有道路不可通行。
注意，两个分部之间可能会有多条道路。
提示：
1 <= n <= 10
1 <= maxDistance <= 10^5
0 <= roads.length <= 1000
roads[i].length == 3
0 <= ui, vi <= n - 1
ui != vi
1 <= wi <= 1000
一开始所有分部之间通过道路互相可以到达。

二进制枚举 + Floyd
数据范围十分小，直接二进制枚举即可，哪怕跑 dijkstra 也不会 TLE
时间复杂度 O(m + 2^n * n^3)
相似题目: 1334. 阈值距离内邻居最少的城市
https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
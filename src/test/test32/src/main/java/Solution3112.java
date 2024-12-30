import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3112 {
    private static final int INF = (int) 1e9;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int x = p[0], y = p[1], wt = p[2];
            g[x].add(new int[]{y, wt});
            g[y].add(new int[]{x, wt});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        // 点，时间
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{0, 0});
        ans[0] = 0;
        boolean[] vis = new boolean[n];
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int x = top[0], t = top[1];
            if (vis[x]) continue;
            vis[x] = true;

            for (int[] p : g[x]) {
                int y = p[0], wt = p[1];
                if (t + wt < disappear[y]) {
                    if (ans[y] > t + wt) {
                        ans[y] = t + wt;
                        pq.add(new int[]{y, t + wt});
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == INF) ans[i] = -1;
        }
        return ans;
    }
}
/*
3112. 访问消失节点的最少时间
https://leetcode.cn/problems/minimum-time-to-visit-disappearing-nodes/description/

第 128 场双周赛 T3。

给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间有一条需要 lengthi 单位时间通过的无向边。
同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 answer[i] 为 -1 。
提示：
1 <= n <= 5 * 10^4
0 <= edges.length <= 10^5
edges[i] == [ui, vi, lengthi]
0 <= ui, vi <= n - 1
1 <= lengthi <= 10^5
disappear.length == n
1 <= disappear[i] <= 10^5

类似堆优化 dijkstra 的思想。
一直以为优先队列中存的是边，2024-04-14 灵神直播纠正存的是：点+最短路。
跟板子还是有点区别：没有使用 vis 数组。
时间复杂度 O(n + mlogm)。
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3123 {
    private static final long INF = (long) 1e18;
    private int n;
    private List<int[]>[] g;

    public boolean[] findAnswer(int n, int[][] edges) {
        this.n = n;
        int m = edges.length;
        // y, wt, i
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = edges[i][0], y = edges[i][1], wt = edges[i][2];
            g[x].add(new int[]{y, wt, i});
            g[y].add(new int[]{x, wt, i});
        }
        long[] dist_st = dijkstra_mlogm(0);
        long[] dist_end = dijkstra_mlogm(n - 1);
        // 需要保留的点
        boolean[] must = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dist_st[i] + dist_end[i] == dist_st[n - 1]) {
                must[i] = true;
            }
        }

        boolean[] ans = new boolean[m];
        // y, wt
        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[]{0, 0});
        while (!q.isEmpty()) {
            long[] top = q.remove();
            int x = (int) top[0];
            long d = top[1];
            for (int[] p : g[x]) {
                int y = p[0], wt = p[1], id = p[2];
                if (must[y] && dist_st[y] == wt + d) {
                    ans[id] = true;
                    q.add(new long[]{y, wt + d});
                }
            }
        }
        return ans;
    }

    private long[] dijkstra_mlogm(int st) {
        // y, wt
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        boolean[] vis = new boolean[n];
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        pq.add(new long[]{st, 0});
        dist[st] = 0;
        while (!pq.isEmpty()) {
            long[] top = pq.remove();
            int x = (int) top[0];
            if (vis[x]) continue;
            vis[x] = true;
            for (int[] p : g[x]) {
                int y = p[0], wt = p[1];
                if (dist[y] > dist[x] + wt) {
                    dist[y] = dist[x] + wt;
                    pq.add(new long[]{y, dist[y]});
                }
            }
        }
        return dist;
    }
}
/*
3123. 最短路径中的边
https://leetcode.cn/problems/find-edges-in-shortest-paths/description/

第 394 场周赛 T4。

给你一个 n 个节点的无向带权图，节点编号为 0 到 n - 1 。图中总共有 m 条边，用二维数组 edges 表示，其中 edges[i] = [ai, bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。
对于节点 0 为出发点，节点 n - 1 为结束点的所有最短路，你需要返回一个长度为 m 的 boolean 数组 answer ，如果 edges[i] 至少 在其中一条最短路上，那么 answer[i] 为 true ，否则 answer[i] 为 false 。
请你返回数组 answer 。
注意，图可能不连通。
提示：
2 <= n <= 5 * 10^4
m == edges.length
1 <= m <= min(5 * 10^4, n * (n - 1) / 2)
0 <= ai, bi < n
ai != bi
1 <= wi <= 10^5
图中没有重边。

最短路 + BFS。
找出需要保留的点。具体就是从 0 和 n-1 出发分别跑一趟 dijkstra，然后在最短路上的带你就是需要保留的。
然后 BFS 处理一下即可。
时间复杂度 O(mlogm + n)。
 */
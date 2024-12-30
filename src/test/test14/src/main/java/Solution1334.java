import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 建图
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{u, w});
        }

        int min = n;
        int minNode = 0;
        // 有 n 个城市，按从 0 到 n-1 编号
        for (int i = 0; i < n; i++) {
            // 从点 i 出发最短路
            int[] dist = dijkstra(n, graph, i);

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (dist[j] <= distanceThreshold) {
                        cnt++;
                    }
                }
            }
            if (cnt <= min) {
                min = cnt;
                minNode = i;
            }
        }
        return minNode;
    }

    private int[] dijkstra(int n, Map<Integer, List<int[]>> graph, int src) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 优先队列优化
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        minHeap.add(new int[]{src, 0});
        dist[src] = 0;

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.remove();
            int cur = top[0];

            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (int[] tuple : graph.getOrDefault(cur, new ArrayList<>())) {
                int next = tuple[0];
                int weight = tuple[1];
                if (dist[next] > dist[cur] + weight) {
                    dist[next] = dist[cur] + weight;
                    minHeap.add(new int[]{next, dist[next]});
                }
            }
        }
        return dist;
    }

    private static final int INF = (int) 1e9;

    public int findTheCity2(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], INF);
            adj[i][i] = 0;
        }
        for (int[] p : edges) {
            int u = p[0], v = p[1], wt = p[2];
            adj[u][v] = adj[v][u] = wt;
        }

        // Floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        int ans = 0;
        int minCnt = n;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && adj[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (minCnt >= cnt) {
                minCnt = cnt;
                ans = i;
            }
        }
        return ans;
    }
}
/*
1334. 阈值距离内邻居最少的城市
https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，
其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
提示：
2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
所有 (fromi, toi) 都是不同的。

对每个城市，跑 dijkstra 得到单源最短路。时间复杂度 O(n * mlogm) 理论上界 49500 * log(4950)
对每个城市 i 和 j 枚举。时间复杂度 O(n^2) 理论上界 10000
因此 时间复杂度 O(n^2 * mlogm) 理论上界 495000 * log(4950)
 */
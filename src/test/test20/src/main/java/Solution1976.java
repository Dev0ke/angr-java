import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1976 {
    private static final long INF = (long) (1e9 * 200);
    private static final long MOD = (long) (1e9 + 7);

    public int countPaths(int n, int[][] roads) {
        // step1: 求出 0 点到其他点最短路
        long[] dist = dijkstra(n, roads);

        // step2: 建 DAG，拓扑序 dp 求方案数
        return topoDP(n, roads, dist);
    }

    private static int topoDP(int n, int[][] roads, long[] dist) {
        Map<Integer, List<Integer>> adj2 = new HashMap<>();
        int[] inDegrees = new int[n];
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            if (dist[v] - dist[u] == w) {
                adj2.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
                inDegrees[v]++;
            } else if (dist[u] - dist[v] == w) {
                adj2.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
                inDegrees[u]++;
            }
        }

        // 拓扑序 dp
        long[] f = new long[n];
        f[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int u = queue.remove();

            for (int v : adj2.getOrDefault(u, new ArrayList<>())) {
                f[v] = (f[v] + f[u]) % MOD;
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return (int) f[n - 1];
    }

    private static long[] dijkstra(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], key -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            adj.computeIfAbsent(road[1], key -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        // dijkstra
        boolean[] visited = new boolean[n];
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        // 优先队列优化
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        minHeap.add(new long[]{0, 0});
        dist[0] = 0;
        while (!minHeap.isEmpty()) {
            long[] top = minHeap.remove();
            int u = (int) top[0];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (int[] tuple : adj.getOrDefault(u, new ArrayList<>())) {
                int v = tuple[0];
                int w = tuple[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    minHeap.add(new long[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    private int n;
    private Map<Integer, List<Integer>> adj2;
    private long[] memo;

    public int countPaths2(int n, int[][] roads) {
        // step1: 求出 0 点到其他点最短路
        long[] dist = dijkstra(n, roads);

        // step2: 建 DAG，dfs 求方案数
        this.n = n;
        this.adj2 = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            if (dist[v] - dist[u] == w) {
                adj2.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            } else if (dist[u] - dist[v] == w) {
                adj2.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            }
        }
        // 记忆化搜索
        memo = new long[n];
        Arrays.fill(memo, -1);
        return (int) dfs(0);
    }

    private long dfs(int u) {
        if (u == n - 1) {
            return 1;
        }
        if (memo[u] != -1) {
            return memo[u];
        }
        memo[u] = 0;
        for (int v : adj2.getOrDefault(u, new ArrayList<>())) {
            memo[u] = (memo[u] + dfs(v)) % MOD;
        }
        return memo[u];
    }
}
/*
1976. 到达目的地的方案数
https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/

第 59 场双周赛 T3。

你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。
给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 10^9 + 7 取余 后返回。
提示：
1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 10^9
ui != vi
任意两个路口之间至多有一条路。
从任意路口出发，你能够到达其他任意路口。

先求出 0 点到其他点最短路，再构造 DAG，用拓扑序 dp/记忆化搜索 求方案数
时间复杂度 O(n^2)
 */
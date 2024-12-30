import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1786 {
    private static final int MOD = (int) (1e9 + 7);
    private int n;
    private Map<Integer, List<int[]>> adj;
    private long[] memo;

    public int countRestrictedPaths(int n, int[][] edges) {
        this.n = n;
        // 建图
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{u, w});
        }

        // 图中有 n 个节点，并按从 1 到 n 给节点编号
        // 用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离
        int[] distanceToLastNode = dijkstra(n);

        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return (int) dfs(distanceToLastNode, 1);
    }

    private long dfs(int[] distanceToLastNode, int cur) {
        if (cur == n) return 1;
        if (memo[cur] != -1) return memo[cur];

        long res = 0L;
        for (int[] tuple : adj.getOrDefault(cur, new ArrayList<>())) {
            int next = tuple[0];
            if (distanceToLastNode[next] < distanceToLastNode[cur]) {
                res += dfs(distanceToLastNode, next);
                res %= MOD;
            }
        }
        memo[cur] = res;
        return res;
    }

    private int[] dijkstra(int src) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
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
            for (int[] tuple : adj.getOrDefault(cur, new ArrayList<>())) {
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
}
/*
1786. 从第一个节点出发到最后一个节点的受限路径数
https://leetcode.cn/problems/number-of-restricted-paths-from-first-to-last-node/

现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，
其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。
从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，
满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。
路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。
受限路径 为满足 distanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。
返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 10^9 + 7 取余 的结果。
提示：
1 <= n <= 2 * 10^4
n - 1 <= edges.length <= 4 * 10^4
edges[i].length == 3
1 <= ui, vi <= n
ui != vi
1 <= weighti <= 10^5
任意两个节点之间至多存在一条边
任意两个节点之间至少存在一条路径

distanceToLastNode[x] 数组的定义可以从节点 n 跑 dijkstra 直接求出
受限路径数 总和可通过 dfs 记忆化搜索求出。
 */
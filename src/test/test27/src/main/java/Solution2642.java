import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2642 {
    static class Graph {
        private final int n;
        private static final int INF = (int) 1e9;
        private final int[][] adj;

        public Graph(int n, int[][] edges) {
            this.n = n;
            adj = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = (i == j) ? 0 : INF;
                }
            }
            for (int[] edge : edges) {
                adj[edge[0]][edge[1]] = edge[2];
            }
        }

        public void addEdge(int[] edge) {
            adj[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int node1, int node2) {
            int[] dist = dijkstra_n2(node1);
            return dist[node2] == INF ? -1 : dist[node2];
        }

        // 暴力 O(n^2)
        private int[] dijkstra_n2(int source) {
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[source] = 0;
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                int x = 0, mind = INF;
                for (int j = 0; j < n; j++) {
                    if (!vis[j] && dist[j] < mind) {
                        x = j;
                        mind = dist[x];
                    }
                }
                vis[x] = true;
                for (int y = 0; y < n; y++) {
                    if (x != y && adj[x][y] != INF) {
                        if (dist[y] > dist[x] + adj[x][y]) {
                            dist[y] = dist[x] + adj[x][y];
                        }
                    }
                }
            }
            return dist;
        }

        private int[] dijkstra_mlogm(int node1) {
            int[] dist = new int[n];
            boolean[] visited = new boolean[n];
            Arrays.fill(dist, INF);
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            priorityQueue.add(new int[]{node1, 0});
            dist[node1] = 0;
            while (!priorityQueue.isEmpty()) {
                int[] top = priorityQueue.remove();
                int x = top[0];
                if (visited[x]) {
                    continue;
                }
                visited[x] = true;
                for (int y = 0; y < n; y++) {
                    if (x != y && adj[x][y] != INF) {
                        if (dist[y] > dist[x] + adj[x][y]) {
                            dist[y] = dist[x] + adj[x][y];
                            priorityQueue.add(new int[]{y, dist[y]});
                        }
                    }
                }
            }
            return dist;
        }
    }

    static class Graph2 {
        private final int n;
        private static final int INF = (int) 1e9;
        private final int[][] adj;

        public Graph2(int n, int[][] edges) {
            this.n = n;
            adj = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = (i == j) ? 0 : INF;
                }
            }
            for (int[] edge : edges) {
                adj[edge[0]][edge[1]] = edge[2];
            }
            // Floyd 初始化 时间复杂度 O(n^3)
            // 定义 f[k][i][j] 表示除了 i 和 j 以外，从 i 到 j 的路径中间点上至多为 k 的时候
            // 从 i 到 j 的最短路的长度
            // 分类讨论：
            // 从 i 到 j 的最短路中间至多为 k-1
            // 从 i 到 j 的最短路中间至多为 k：说明 k 一定是中间节点
            // f[k][i][j] = min(f[k-1][i][j], f[k-1][i][k] + f[k-1][k][j])
            // 空间压缩 f[i][j] = min(f[i][j], f[i][k] + f[k][j])
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }
        }

        // 新增边 时间复杂度 O(n^2)
        public void addEdge(int[] edge) {
            int u = edge[0], v = edge[1], w = edge[2];
            // 无效更新
            if (w > adj[u][v]) {
                return;
            }
            adj[u][v] = w;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][u] + adj[u][v] + adj[v][j]);
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            return adj[node1][node2] == INF ? -1 : adj[node1][node2];
        }
    }
}
/*
2642. 设计可以求最短路径的图类
https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/

第 102 场双周赛 T4。

给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。
请你实现一个 Graph 类：
- Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
- addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两个节点之间没有有向边。
- int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1 。一条路径的代价是路径中所有边代价之和。
提示：
1 <= n <= 100
0 <= edges.length <= n * (n - 1)
edges[i].length == edge.length == 3
0 <= fromi, toi, from, to, node1, node2 <= n - 1
1 <= edgeCosti, edgeCost <= 10^6
图中任何时候都不会有重边和自环。
调用 addEdge 至多 100 次。
调用 shortestPath 至多 100 次。

最短路。
如果题目调整为调用 addEdge 至多 100 次。调用 shortestPath 至多 1e5 次。将是道好题。查多改少场景需要用到 Floyd。
比赛时使用了 dijkstra 堆优化模板。
时间复杂度 O(qmlogn)。
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2203 {
    private static final long INF = Long.MAX_VALUE / 10;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        int m = edges.length;

        // 正向图
        LinkedForwardStar adj = new LinkedForwardStar(n, m);
        // 反向图
        LinkedForwardStar reAdj = new LinkedForwardStar(n, m);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.add(u, v, w);
            reAdj.add(v, u, w);
        }

        long[] src1Dist = adj.dijkstra(src1);
        long[] src2Dist = adj.dijkstra(src2);
        long[] destDist = reAdj.dijkstra(dest);

        // 枚举中间点
        long min = INF;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, src1Dist[i] + src2Dist[i] + destDist[i]);
        }
        return min == INF ? -1 : min;
    }

    private static class LinkedForwardStar {
        // n 个点
        private final int N;
        // m 条边
        private final int M;
        // 链式前向星
        private final int[] headArr;
        private final int[] edgeArr;
        private final int[] nextArr;
        private final int[] weightArr;
        private int idx;

        // 链式前向星
        public LinkedForwardStar(int n, int m) {
            this.N = n + 1;
            this.M = m + 1;
            this.headArr = new int[N];
            // 初始化链表头
            Arrays.fill(headArr, -1);
            this.edgeArr = new int[M];
            this.nextArr = new int[M];
            this.weightArr = new int[M];
            this.idx = 0;
        }

        public void add(int u, int v, int w) {
            this.edgeArr[idx] = v;
            this.nextArr[idx] = headArr[u];
            this.headArr[u] = idx;
            this.weightArr[idx] = w;
            this.idx++;
        }

        // 从 src 点出发跑 dijkstra 返回 dist[] 数组
        public long[] dijkstra(int src) {
            boolean[] visited = new boolean[N];
            long[] dist = new long[N];
            Arrays.fill(dist, INF);

            // 优先队列优化
            PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
            minHeap.add(new long[]{src, 0});
            dist[src] = 0;

            while (!minHeap.isEmpty()) {
                long[] poll = minHeap.poll();
                int id = (int) poll[0];

                if (visited[id]) {
                    continue;
                }
                visited[id] = true;
                for (int i = headArr[id]; i != -1; i = nextArr[i]) {
                    int j = edgeArr[i];
                    if (dist[j] > dist[id] + weightArr[i]) {
                        dist[j] = dist[id] + weightArr[i];
                        minHeap.add(new long[]{j, dist[j]});
                    }
                }
            }
            return dist;
        }
    }
}
/*
2203. 得到要求路径的最小带权子图
https://leetcode.cn/problems/minimum-weighted-subgraph-with-the-required-paths/

第 284 场周赛 T4。

给你一个整数 n ，它表示一个 带权有向 图的节点数，节点编号为 0 到 n - 1 。
同时给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi, weighti] ，表示从 fromi 到 toi 有一条边权为 weighti 的 有向 边。
最后，给你三个 互不相同 的整数 src1 ，src2 和 dest ，表示图中三个不同的点。
请你从图中选出一个 边权和最小 的子图，使得从 src1 和 src2 出发，在这个子图中，都 可以 到达 dest 。如果这样的子图不存在，请返回 -1 。
子图 中的点和边都应该属于原图的一部分。子图的边权和定义为它所包含的所有边的权值之和。
提示：
3 <= n <= 10^5
0 <= edges.length <= 10^5
edges[i].length == 3
0 <= fromi, toi, src1, src2, dest <= n - 1
fromi != toi
src1 ，src2 和 dest 两两不同。
1 <= weight[i] <= 10^5

dijkstra 单源最短路
时间复杂度 O(nlogm)
相似题目: 743. 网络延迟时间
https://leetcode.cn/problems/network-delay-time/
 */
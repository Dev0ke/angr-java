import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution743 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int networkDelayTime(int[][] times, int n, int k) {
        // 有 n 个网络节点，标记为 1 到 n
        // 邻接矩阵 weights[ui][vi] = wi 表示从 ui 到 vi 有权重为 wi 的边
        int[][] weights = buildAdj(times, n);
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    weights[i][j] = Math.min(weights[i][j], weights[i][p] + weights[p][j]);
                }
            }
        }
        // 遍历答案
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, weights[k][i]);
        }
        return max == INF ? -1 : max;
    }

    private int[][] buildAdj(int[][] times, int n) {
        int[][] weights = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    weights[i][j] = weights[j][i] = 0;
                } else {
                    weights[i][j] = weights[j][i] = INF;
                }
            }
        }
        for (int[] time : times) {
            int ui = time[0];
            int vi = time[1];
            int wi = time[2];
            weights[ui][vi] = wi;
        }
        return weights;
    }

    public int networkDelayTime2(int[][] times, int n, int k) {
        int m = times.length;

        LinkedForwardStar adjacency = new LinkedForwardStar(n, m);
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjacency.add(u, v, w);
        }

        // dijkstra
        int[] dist = adjacency.dijkstra(k);

        // 遍历答案
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
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
        public int[] dijkstra(int src) {
            boolean[] visited = new boolean[N];
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            // 优先队列优化
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            minHeap.add(new int[]{src, 0});
            dist[src] = 0;

            while (!minHeap.isEmpty()) {
                int[] poll = minHeap.poll();
                int id = poll[0];

                if (visited[id]) {
                    continue;
                }
                visited[id] = true;
                for (int i = headArr[id]; i != -1; i = nextArr[i]) {
                    int j = edgeArr[i];
                    if (dist[j] > dist[id] + weightArr[i]) {
                        dist[j] = dist[id] + weightArr[i];
                        minHeap.add(new int[]{j, dist[j]});
                    }
                }
            }
            return dist;
        }
    }
}
/*
743. 网络延迟时间
https://leetcode.cn/problems/network-delay-time/

有 n 个网络节点，标记为 1 到 n。
给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
提示：
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
所有 (ui, vi) 对都 互不相同（即，不含重复边）

最短路。
Floyd 时间复杂度 O(n^3)
堆优化 dijkstra 时间复杂度 O(nlogm)
【宫水三叶】涵盖所有的「存图方式」与「最短路算法（详尽注释）」
https://leetcode.cn/problems/network-delay-time/solution/gong-shui-san-xie-yi-ti-wu-jie-wu-chong-oghpz/
 */
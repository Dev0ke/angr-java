import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int m = edges.length;

        LinkedForwardStar adjacency = new LinkedForwardStar(n, m * 2);
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adjacency.add(u, v, w);
            adjacency.add(v, u, w);
        }

        double[] dist = adjacency.dijkstra(start);
        return dist[end];
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
        private final double[] weightArr;
        private int idx;

        public LinkedForwardStar(int n, int m) {
            this.N = n + 1;
            this.M = m + 1;
            this.headArr = new int[N];
            // 初始化链表头
            Arrays.fill(headArr, -1);
            this.edgeArr = new int[M];
            this.nextArr = new int[M];
            this.weightArr = new double[M];
            this.idx = 0;
        }

        public void add(int u, int v, double w) {
            this.edgeArr[idx] = v;
            this.nextArr[idx] = headArr[u];
            this.headArr[u] = idx;
            this.weightArr[idx] = w;
            this.idx++;
        }

        public double[] dijkstra(int src) {
            boolean[] visited = new boolean[N];
            double[] dist = new double[N];
            Arrays.fill(dist, 0);

            // 优先队列 按 成功概率 降序排列
            PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> {
                if (o1.dist == o2.dist) {
                    return Integer.compare(o1.node, o2.node);
                }
                return Double.compare(o2.dist, o1.dist);
            });
            maxHeap.add(new Node(src, 1));
            dist[src] = 1;

            while (!maxHeap.isEmpty()) {
                Node poll = maxHeap.poll();
                int id = poll.node;

                if (visited[id]) {
                    continue;
                }
                visited[id] = true;
                for (int i = headArr[id]; i != -1; i = nextArr[i]) {
                    int j = edgeArr[i];
                    // 变种
                    if (dist[j] < dist[id] * weightArr[i]) {
                        dist[j] = dist[id] * weightArr[i];
                        maxHeap.add(new Node(j, dist[j]));
                    }
                }
            }
            return dist;
        }

        private static class Node {
            int node;
            double dist;

            public Node(int node, double dist) {
                this.node = node;
                this.dist = dist;
            }
        }
    }
}
/*
1514. 概率最大的路径
https://leetcode.cn/problems/path-with-maximum-probability/

给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，
其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
提示：
2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
每两个节点之间最多有一条边

dijkstra 变种，加法变乘法，最小变最大。
 */
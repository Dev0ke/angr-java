import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionP2737 {
    static final int INF = (int) 1e9;
    private List<int[]>[] g;

    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (List<Integer> p : edges) {
            int x = p.get(0), y = p.get(1), wt = p.get(2);
            g[x].add(new int[]{y, wt});
        }
        int[] dist = dijkstra_mlogm(n, s);
        int mn = INF;
        for (int t : marked) {
            mn = Math.min(mn, dist[t]);
        }
        return mn == INF ? -1 : mn;
    }

    private int[] dijkstra_mlogm(int n, int node) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        pq.add(new int[]{node, 0});
        dist[node] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int x = top[0];
            if (vis[x]) continue;
            vis[x] = true;
            for (int[] p : g[x]) {
                int y = p[0], wt = p[1];
                if (dist[y] > dist[x] + wt) {
                    dist[y] = dist[x] + wt;
                    pq.add(new int[]{y, dist[y]});
                }
            }
        }
        return dist;
    }
}
/*
$2737. 找到最近的标记节点
https://leetcode.cn/problems/find-the-closest-marked-node/description/

给定一个正整数 n ，表示一个 索引从 0 开始的有向加权 图的节点数量，以及一个 索引从 0 开始的二维数组 edges ，其中 edges[i] = [ui, vi, wi] 表示从节点 ui 到节点 vi 的一条权重为 wi 的边。
并给定一个节点 s 和一个节点数组 marked ；你的任务是找到从 s 到 marked 中 任何 节点的 最短 距离。
返回一个整数，表示从 s 到 marked 中任何节点的最短距离，如果从 s 到任何标记节点没有路径，则返回 -1 。
提示：
2 <= n <= 500
1 <= edges.length <= 10^4
edges[i].length = 3
0 <= edges[i][0], edges[i][1] <= n - 1
1 <= edges[i][2] <= 10^6
1 <= marked.length <= n - 1
0 <= s, marked[i] <= n - 1
s != marked[i]
如果 i != j 则 marked[i] != marked[j]
图中可能有 重复的边 。
图的生成不会出现 自环 。

dijkstra 单源最短路。
 */
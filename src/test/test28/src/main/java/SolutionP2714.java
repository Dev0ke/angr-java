import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionP2714 {
    private static final int INF = (int) 1e9;
    private List<int[]>[] g;

    public int shortestPathWithHops(int n, int[][] edges, int s, int d, int k) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(new int[]{p[1], p[2]});
            g[p[1]].add(new int[]{p[0], p[2]});
        }
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        boolean[][] seen = new boolean[n][k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, s, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int td = top[0], u = top[1], tk = top[2];
            if (seen[u][tk]) continue;
            seen[u][tk] = true;
            for (int[] nxt : g[u]) {
                int v = nxt[0], nd = nxt[1];
                if (dist[v][tk] > td + nd) {
                    dist[v][tk] = td + nd;
                    pq.add(new int[]{td + nd, v, tk});
                }
                if (tk < k && dist[v][tk + 1] > td) {
                    dist[v][tk + 1] = td;
                    pq.add(new int[]{td, v, tk + 1});
                }
            }
        }
        return Arrays.stream(dist[d]).min().orElseThrow();
    }
}
/*
$2714. 找到 K 次跨越的最短路径
https://leetcode.cn/problems/find-shortest-path-with-k-hops/description/

现给定一个正整数 n ，它表示一个 索引从 0 开始的无向带权连接图 的节点数，以及一个 索引从 0 开始的二维数组 edges ，其中 edges[i] = [ui, vi, wi] 表示节点 ui 和 vi 之间存在权重为 wi 的边。
还给定两个节点 s 和 d ，以及一个正整数 k ，你的任务是找到从 s 到 d 的 最短 路径，但你可以 最多 跨越 k 条边。换句话说，将 最多 k 条边的权重设为 0，然后找到从 s 到 d 的 最短 路径。
返回满足给定条件的从 s 到 d 的 最短 路径的长度。
提示：
2 <= n <= 500
n - 1 <= edges.length <= n * (n - 1) / 2
edges[i].length = 3
0 <= edges[i][0], edges[i][1] <= n - 1
1 <= edges[i][2] <= 10^6
0 <= s, d, k <= n - 1
s != d
输入的生成确保图是 连通 的，并且没有 重复的边 或 自环。

分层图最短路
https://oi-wiki.org/graph/node/#%E5%88%86%E5%B1%82%E5%9B%BE%E6%9C%80%E7%9F%AD%E8%B7%AF
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2699 {
    private static final int INF = (int) 1e9;
    private int n;
    private int[][] edges;
    private Map<Integer, List<int[]>> adj;
    private int[][] dist;
    private int delta;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        this.n = n;
        this.edges = edges;
        // 建图
        adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], y = edges[i][1];
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, i});
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, i});
        }
        // 跑两轮最短路
        dist = new int[2][n];

        // 第 1 轮：-1 置 1
        dijkstra_n2(source, 0);
        delta = target - dist[0][destination];
        if (delta < 0) {
            return new int[0][];
        }
        // 第 2 轮：修改 edges
        dijkstra_n2(source, 1);
        // 最短路无法再变大，无法达到 target
        if (dist[1][destination] < target) {
            return new int[0][];
        }

        // 没修改的 -1 全部置 1
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = 1;
            }
        }
        return edges;
    }

    // 暴力 O(n^2)
    private void dijkstra_n2(int source, int k) {
        Arrays.fill(dist[k], INF);
        dist[k][source] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = 0, mind = INF;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && dist[k][j] < mind) {
                    x = j;
                    mind = dist[k][x];
                }
            }
            vis[x] = true;
            for (int[] tuple : adj.getOrDefault(x, new ArrayList<>())) {
                int y = tuple[0], edgeId = tuple[1];
                int wt = edges[edgeId][2];
                // -1 改成 1
                if (wt == -1) {
                    wt = 1;
                }
                // 第 2 轮 改成 w
                if (k == 1 && edges[edgeId][2] == -1) {
                    int w = delta + dist[0][y] - dist[1][x];
                    if (wt < w) {
                        wt = w;
                        // 直接在 edges 上修改
                        edges[edgeId][2] = w;
                    }
                }
                // 更新最短路
                if (dist[k][y] > dist[k][x] + wt) {
                    dist[k][y] = dist[k][x] + wt;
                }
            }
        }
    }
}
/*
2699. 修改图中的边权
https://leetcode.cn/problems/modify-graph-edge-weights/

第 346 场周赛 T4。

给你一个 n 个节点的 无向带权连通 图，节点编号为 0 到 n - 1 ，再给你一个整数数组 edges ，其中 edges[i] = [ai, bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。
部分边的边权为 -1（wi = -1），其他边的边权都为 正 数（wi > 0）。
你需要将所有边权为 -1 的边都修改为范围 [1, 2 * 10^9] 中的 正整数 ，使得从节点 source 到节点 destination 的 最短距离 为整数 target 。
如果有 多种 修改方案可以使 source 和 destination 之间的最短距离等于 target ，你可以返回任意一种方案。
如果存在使 source 到 destination 最短距离为 target 的方案，请你按任意顺序返回包含所有边的数组（包括未修改边权的边）。如果不存在这样的方案，请你返回一个 空数组 。
注意：你不能修改一开始边权为正数的边。
提示：
1 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= ai, bi < n
wi = -1 或者 1 <= wi <= 10^7
ai != bi
0 <= source, destination < n
source != destination
1 <= target <= 10^9
输入的图是连通图，且没有自环和重边。

两次 dijkstra
时间复杂度 O(n^2)
相似题目: B. Complete The Graph
https://codeforces.com/contest/715/problem/B
2642. 设计可以求最短路径的图类
https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionP2204 {
    private Map<Integer, List<Integer>> g;
    private int[] deg;
    private int[] ans;

    public int[] distanceToCycle(int n, int[][] edges) {
        g = new HashMap<>();
        deg = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            g.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            deg[u]++;
            deg[v]++;
        }

        // 拓扑排序，剪掉所有树枝
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                deg[v]--;
                if (deg[v] == 1) {
                    queue.add(v);
                }
            }
        }

        // 从基环出发，求所有树枝上的点的深度
        ans = new int[n];
        for (int root = 0; root < n; root++) {
            if (deg[root] > 1) {
                f(root, -1);
            }
        }
        return ans;
    }

    private void f(int u, int fa) {
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v != fa && deg[v] < 2) {
                ans[v] = ans[u] + 1;
                f(v, u);
            }
        }
    }
}
/*
$2204. 无向图中到环的距离
https://leetcode.cn/problems/distance-to-a-cycle-in-undirected-graph/

给定一个正整数 n，表示一个 连通无向图 中的节点数，该图 只包含一个 环。节点编号为 0 ~ n - 1(含)。
你还得到了一个二维整数数组 edges，其中 edges[i] = [node1i, node2i] 表示有一条 双向 边连接图中的 node1i 和 node2i。
两个节点 a 和 b 之间的距离定义为从 a 到 b 所需的 最小边数。
返回一个长度为 n 的整数数组 answer，其中 answer[i] 是第 i 个节点与环中任何节点之间的最小距离。
提示:
3 <= n <= 10^5
edges.length == n
edges[i].length == 2
0 <= node1i, node2i <= n - 1
node1i != node2i
图是连通的。
这个图只有一个环。
任何顶点对之间最多只有一条边。

无向基环树 https://leetcode.cn/problems/distance-to-a-cycle-in-undirected-graph/solution/by-endlesscheng-422f/
 */

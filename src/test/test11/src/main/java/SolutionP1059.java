import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionP1059 {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] deg = new int[n];
        for (int[] edge : edges) {
            // 逆向
            int u = edge[1];
            int v = edge[0];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            deg[v]++;
        }
        if (deg[destination] > 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            if (u == source) {
                return true;
            }
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                deg[v]--;
                if (deg[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return false;
    }
}
/*
$1059. 从始点到终点的所有路径
https://leetcode.cn/problems/all-paths-from-source-lead-to-destination/

给定有向图的边 edges，以及该图的始点 source 和目标终点 destination，确定从始点 source 出发的所有路径是否最终结束于目标终点 destination，即：
- 从始点 source 到目标终点 destination 存在至少一条路径
- 如果存在从始点 source 到没有出边的节点的路径，则该节点就是路径终点。
- 从始点source到目标终点 destination 可能路径数是有限数字
当从始点 source 出发的所有路径都可以到达目标终点 destination 时返回 true，否则返回 false。
提示：
1 <= n <= 10^4
0 <= edges.length <= 10^4
edges.length == 2
0 <= ai, bi <= n - 1
0 <= source <= n - 1
0 <= destination <= n - 1
给定的图中可能带有自环和平行边。

终点到起点 拓扑排序
 */
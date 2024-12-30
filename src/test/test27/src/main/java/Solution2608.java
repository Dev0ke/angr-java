import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2608 {
    private int n;
    private Map<Integer, List<Integer>> adj;

    public int findShortestCycle(int n, int[][] edges) {
        this.n = n;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        int min = n + 1;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, bfs(i));
        }
        return (min == n + 1) ? -1 : min;
    }

    private int bfs(int start) {
        int ans = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, -1});
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[start] = 0;

        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int x = tuple[0], fa = tuple[1];
            for (int y : adj.getOrDefault(x, new ArrayList<>())) {
                if (dis[y] < 0) {
                    // 第一次遇到
                    dis[y] = dis[x] + 1;
                    queue.add(new int[]{y, x});
                } else {
                    // 第二次遇到
                    if (y != fa) {
                        ans = Math.min(ans, dis[x] + dis[y] + 1);
                    }
                }
            }
        }
        // 无环
        return ans;
    }
}
/*
2608. 图中的最短环
https://leetcode.cn/problems/shortest-cycle-in-a-graph/

第 101 场双周赛 T4。

现有一个含 n 个顶点的 双向 图，每个顶点按从 0 到 n - 1 标记。图中的边由二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和 vi 之间存在一条边。
每对顶点最多通过一条边连接，并且不存在与自身相连的顶点。
返回图中 最短 环的长度。如果不存在环，则返回 -1 。
环 是指以同一节点开始和结束，并且路径中的每条边仅使用一次。
提示：
2 <= n <= 1000
1 <= edges.length <= 1000
edges[i].length == 2
0 <= ui, vi < n
ui != vi
不存在重复的边

最小环模板。https://oi-wiki.org/graph/min-circle/
由于为无权图，所以不需要 O(n^3) 的 Floyd
BFS 即可。
时间复杂度 O(nm)
 */
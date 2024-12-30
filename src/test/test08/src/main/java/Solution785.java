import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] colors = new int[n];
        // -1:未染色 0:红色 1:蓝色
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean setColor(int[][] graph, int[] colors, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        colors[i] = 0;

        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : graph[x]) {
                if (colors[y] != -1) {
                    if (colors[y] == colors[x]) {
                        return false;
                    }
                } else {
                    colors[y] = 1 ^ colors[x];
                    q.add(y);
                }
            }
        }
        return true;
    }
}
/*
785. 判断二分图
https://leetcode.cn/problems/is-graph-bipartite/

存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，
其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
- 不存在自环（graph[u] 不包含 u）。
- 不存在平行边（graph[u] 不包含重复值）。
- 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
- 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
如果图是二分图，返回 true ；否则，返回 false 。
提示：
graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] 不会包含 u
graph[u] 的所有值 互不相同
如果 graph[u] 包含 v，那么 graph[v] 也会包含 u

BFS。
二部图判定，常用方法是节点染色，即先选取图中任意一点，染成红色，再将其相邻节点染成蓝色，判定染色后是否会有相邻两个节点颜色相同，
若存在相邻两个节点颜色相同，不是二部图，否则，是二部图。
相似题目: 886. 可能的二分法
https://leetcode.cn/problems/possible-bipartition/
 */
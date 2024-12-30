import java.util.LinkedList;
import java.util.Queue;

public class Solution847 {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[len][1 << len];
        for (int i = 0; i < len; i++) {
            queue.add(new int[]{i, 1 << i, 0});
            visited[i][1 << i] = true;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int u = cur[0];
            int mask = cur[1];
            int dist = cur[2];

            if (mask == (1 << len) - 1) {
                return dist;
            }

            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!visited[v][maskV]) {
                    queue.add(new int[]{v, maskV, dist + 1});
                    visited[v][maskV] = true;
                }
            }
        }
        return -1;
    }
}
/*
847. 访问所有节点的最短路径
https://leetcode.cn/problems/shortest-path-visiting-all-nodes/

存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
提示：
n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] 不包含 i
如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
输入的图总是连通图

状态压缩 BFS。
时间复杂度 O(n^2 * 2^n)
空间复杂度 O(n * 2^n)
 */
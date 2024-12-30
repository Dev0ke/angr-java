import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 0:红色 1:蓝色
        List<Integer>[][] graphs = new List[2][n];
        Arrays.setAll(graphs[0], e -> new ArrayList<>());
        Arrays.setAll(graphs[1], e -> new ArrayList<>());
        for (int[] e : redEdges) {
            graphs[0][e[0]].add(e[1]);
        }
        for (int[] e : blueEdges) {
            graphs[1][e[0]].add(e[1]);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        boolean[][] vis = new boolean[2][n];

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int x = tuple[0], color = tuple[1];
                for (Integer y : graphs[color ^ 1][x]) {
                    if (vis[color ^ 1][y]) continue;
                    vis[color ^ 1][y] = true;
                    if (ans[y] == -1) ans[y] = dist;
                    queue.add(new int[]{y, color ^ 1});
                }
            }
        }
        return ans;
    }
}
/*
1129. 颜色交替的最短路径
https://leetcode.cn/problems/shortest-path-with-alternating-colors/

在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
提示：
1 <= n <= 100
red_edges.length <= 400
blue_edges.length <= 400
red_edges[i].length == blue_edges[i].length == 2
0 <= red_edges[i][j], blue_edges[i][j] < n

最短路首先想到 BFS，本题限制条件是颜色交替，模拟完事。
 */
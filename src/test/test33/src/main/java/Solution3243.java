import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[i - 1].add(i);
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int x = queries[i][0], y = queries[i][1];
            g[x].add(y);
            ans[i] = bfs(n, g);
        }
        return ans;
    }

    private int bfs(int n, List<Integer>[] g) {
        int[] dist = new int[n];
        Arrays.fill(dist, n);
        dist[0] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer x = q.remove();
            for (Integer y : g[x]) {
                if (dist[y] > dist[x] + 1) {
                    dist[y] = dist[x] + 1;
                    q.add(y);
                }
            }
        }
        return dist[n - 1];
    }
}
/*
3243. 新增道路查询后的最短距离 I
https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i/description/

给你一个整数 n 和一个二维整数数组 queries。
有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。
返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度。
提示：
3 <= n <= 500
1 <= queries.length <= 500
queries[i].length == 2
0 <= queries[i][0] < queries[i][1] < n
1 < queries[i][1] - queries[i][0]
查询中没有重复的道路。

请务必记得，最短路除了 Floyd 和 dijkstra，还有无权图的 BFS！！
时间复杂度 O(q(n + q))
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1466 {
    private List<int[]>[] g;

    public int minReorder(int n, int[][] connections) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : connections) {
            int x = p[0], y = p[1];
            // 因为从 0 开始遍历，所以正向边记为 1，反向边记为 0
            g[x].add(new int[]{y, 1});
            g[y].add(new int[]{x, 0});
        }
        return dfs(0, -1);
    }

    private int dfs(int x, int fa) {
        int res = 0;
        for (int[] p : g[x]) {
            int y = p[0], wt = p[1];
            if (y != fa) {
                res += wt + dfs(y, x);
            }
        }
        return res;
    }
}
/*
1466. 重新规划路线
https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
提示：
2 <= n <= 5 * 10^4
connections.length == n-1
connections[i].length == 2
0 <= connections[i][0], connections[i][1] <= n-1
connections[i][0] != connections[i][1]

DFS。
因为从 0 开始遍历，所以正向边记为 1，反向边记为 0
时间复杂度 O(n)
 */
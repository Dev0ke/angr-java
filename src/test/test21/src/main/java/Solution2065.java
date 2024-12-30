import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2065 {
    private int[] values;
    private int maxTime;
    private List<int[]>[] g;
    private boolean[] vis;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.maxTime = maxTime;
        int n = values.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int x = p[0], y = p[1], time = p[2];
            g[x].add(new int[]{y, time});
            g[y].add(new int[]{x, time});
        }
        vis = new boolean[n];
        vis[0] = true;
        return dfs(0, 0, values[0]);
    }

    private int dfs(int x, int sumTime, int sumValue) {
        int res = x == 0 ? sumValue : 0;
        for (int[] e : g[x]) {
            int y = e[0], t = e[1];
            if (sumTime + t > maxTime) {
                continue;
            }
            if (vis[y]) {
                res = Math.max(res, dfs(y, sumTime + t, sumValue));
            } else {
                vis[y] = true;
                // 每个节点的价值至多算入价值总和中一次
                res = Math.max(res, dfs(y, sumTime + t, sumValue + values[y]));
                vis[y] = false;
            }
        }
        return res;
    }
}
/*
2065. 最大化一张图中的路径价值
https://leetcode.cn/problems/maximum-path-quality-of-a-graph/

第 266 场周赛 T4。

给你一张 无向 图，图中有 n 个节点，节点编号从 0 到 n - 1 （都包括）。同时给你一个下标从 0 开始的整数数组 values ，
其中 values[i] 是第 i 个节点的 价值 。同时给你一个下标从 0 开始的二维整数数组 edges ，
其中 edges[j] = [uj, vj, timej] 表示节点 uj 和 vj 之间有一条需要 timej 秒才能通过的无向边。最后，给你一个整数 maxTime 。
合法路径 指的是图中任意一条从节点 0 开始，最终回到节点 0 ，且花费的总时间 不超过 maxTime 秒的一条路径。
你可以访问一个节点任意次。一条合法路径的 价值 定义为路径中 不同节点 的价值 之和 （每个节点的价值 至多 算入价值总和中一次）。
请你返回一条合法路径的 最大 价值。
注意：每个节点 至多 有 四条 边与之相连。
提示：
n == values.length
1 <= n <= 1000
0 <= values[i] <= 10^8
0 <= edges.length <= 2000
edges[j].length == 3
0 <= uj < vj <= n - 1
10 <= timej, maxTime <= 100
[uj, vj] 所有节点对 互不相同 。
每个节点 至多有四条 边。
图可能不连通。

由于 10 <= timej, maxTime <= 100 且 每个节点 至多 有 四条 边与之相连
因此路径上的节点数不会超 10，至多 4 条边，即 数量级 4^10 <= 1,048,576
DFS 暴力搜索即可。
 */
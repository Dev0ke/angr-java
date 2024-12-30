import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2685 {
    private Map<Integer, List<Integer>> adj;
    private boolean[] vis;
    private int cntV, cntE;

    public int countCompleteComponents(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        int ans = 0;
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cntV = 0;
                cntE = 0;
                dfs(i);
                if (cntE == cntV * (cntV - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int x) {
        vis[x] = true;
        cntV++;
        List<Integer> yList = adj.getOrDefault(x, new ArrayList<>());
        cntE += yList.size();
        for (Integer y : yList) {
            if (vis[y]) continue;
            dfs(y);
        }
    }
}
/*
2685. 统计完全连通分量的数量
https://leetcode.cn/problems/count-the-number-of-complete-components/

第 345 场周赛 T4。

给你一个整数 n 。现有一个包含 n 个顶点的 无向 图，顶点按从 0 到 n - 1 编号。给你一个二维整数数组 edges 其中 edges[i] = [ai, bi] 表示顶点 ai 和 bi 之间存在一条 无向 边。
返回图中 完全连通分量 的数量。
如果在子图中任意两个顶点之间都存在路径，并且子图中没有任何一个顶点与子图外部的顶点共享边，则称其为 连通分量 。
如果连通分量中每对节点之间都存在一条边，则称其为 完全连通分量 。
提示：
1 <= n <= 50
0 <= edges.length <= n * (n - 1) / 2
edges[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
不存在重复的边

DFS 统计各连通块的 边数 和 点数。
时间复杂度 O(n)
相似题目: B - Reversible Cards
https://atcoder.jp/contests/arc111/tasks/arc111_b
 */
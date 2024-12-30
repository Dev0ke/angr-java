import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2316 {
    private List<Integer>[] g;
    private boolean[] vis;
    private long cntV;

    public long countPairs(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        vis = new boolean[n];
        long ans = 0;
        long tot = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cntV = 0;
                dfs(i);
                ans += cntV * tot;
                tot += cntV;
            }
        }
        return ans;
    }

    private void dfs(int x) {
        vis[x] = true;
        cntV++;
        for (Integer y : g[x]) {
            if (!vis[y]) {
                dfs(y);
            }
        }
    }
}
/*
2316. 统计无向图中无法互相到达点对数
https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

第 81 场双周赛 T2。

给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
请你返回 无法互相到达 的不同 点对数目 。
提示：
1 <= n <= 10^5
0 <= edges.length <= 2 * 10^5
edges[i].length == 2
0 <= ai, bi < n
ai != bi
不会有重复边。

并查集 统计 每个点的联通分量。
时间复杂度 O(n * α(n))
 */
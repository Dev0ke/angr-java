import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2846 {
    private Map<Integer, List<int[]>> g;
    private int[][] pa;
    private int[][][] pacnt;
    private int[] depth;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        g = new HashMap<>();
        for (int[] e : edges) {
            int x = e[0], y = e[1], wt = e[2] - 1;
            g.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, wt});
            g.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, wt});
        }

        int m = 32 - Integer.numberOfLeadingZeros(n);
        pa = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(pa[i], -1);
        }
        pacnt = new int[n][m][26];
        depth = new int[n];
        dfs(0, -1);

        for (int i = 0; i + 1 < m; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                if (p != -1) {
                    int pp = pa[p][i];
                    pa[x][i + 1] = pp;
                    for (int j = 0; j < 26; j++) {
                        pacnt[x][i + 1][j] = pacnt[x][i][j] + pacnt[p][i][j];
                    }
                }
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int qi = 0; qi < q; qi++) {
            int x = queries[qi][0];
            int y = queries[qi][1];
            int pathLen = depth[x] + depth[y];
            int[] cw = new int[26];
            if (depth[x] > depth[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            // 让 y 和 x 在同一深度
            for (int k = depth[y] - depth[x]; k > 0; k &= k - 1) {
                int i = Integer.numberOfTrailingZeros(k);
                int p = pa[y][i];
                for (int j = 0; j < 26; j++) {
                    cw[j] += pacnt[y][i][j];
                }
                y = p;
            }

            if (y != x) {
                for (int i = m - 1; i >= 0; i--) {
                    int px = pa[x][i];
                    int py = pa[y][i];
                    if (px != py) {
                        for (int j = 0; j < 26; j++) {
                            cw[j] += pacnt[x][i][j] + pacnt[y][i][j];
                        }
                        x = px;
                        y = py; // x 和 y 同时上跳 2^i 步
                    }
                }
                for (int j = 0; j < 26; j++) {
                    cw[j] += pacnt[x][0][j] + pacnt[y][0][j];
                }
                x = pa[x][0];
            }

            int lca = x;
            pathLen -= depth[lca] * 2;
            int maxCw = 0;
            for (int i = 0; i < 26; i++) {
                maxCw = Math.max(maxCw, cw[i]);
            }
            ans[qi] = pathLen - maxCw;
        }
        return ans;
    }

    private void dfs(int x, int fa) {
        pa[x][0] = fa;
        for (int[] p : g.getOrDefault(x, new ArrayList<>())) {
            int y = p[0], wt = p[1];
            if (y == fa) continue;
            pacnt[y][0][wt] = 1;
            depth[y] = depth[x] + 1;
            dfs(y, x);
        }
    }
}
/*
2846. 边权重均等查询
https://leetcode.cn/problems/minimum-edge-weight-equilibrium-queries-in-a-tree/

第 361 场周赛 T4。

现有一棵由 n 个节点组成的无向树，节点按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi, wi] 表示树中存在一条位于节点 ui 和节点 vi 之间、权重为 wi 的边。
另给你一个长度为 m 的二维整数数组 queries ，其中 queries[i] = [ai, bi] 。对于每条查询，请你找出使从 ai 到 bi 路径上每条边的权重相等所需的 最小操作次数 。在一次操作中，你可以选择树上的任意一条边，并将其权重更改为任意值。
注意：
- 查询之间 相互独立 的，这意味着每条新的查询时，树都会回到 初始状态 。
- 从 ai 到 bi的路径是一个由 不同 节点组成的序列，从节点 ai 开始，到节点 bi 结束，且序列中相邻的两个节点在树中共享一条边。
返回一个长度为 m 的数组 answer ，其中 answer[i] 是第 i 条查询的答案。
提示：
1 <= n <= 10^4
edges.length == n - 1
edges[i].length == 3
0 <= ui, vi < n
1 <= wi <= 26
生成的输入满足 edges 表示一棵有效的树
1 <= queries.length == m <= 2 * 10^4
queries[i].length == 2
0 <= ai, bi < n

LCA 树上倍增
 */
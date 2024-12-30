public class Solution3108 {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);
        for (int[] p : edges) {
            int x = p[0], y = p[1], wt = p[2];
            x = dsu.find(x);
            y = dsu.find(y);
            dsu.and[y] &= wt;
            if (x != y) {
                dsu.fa[x] = y;
                dsu.and[y] &= dsu.and[x];
            }
        }

        int q = query.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int x = query[i][0], y = query[i][1];
            if (x == y) continue;
            x = dsu.find(x);
            y = dsu.find(y);
            if (x != y) ans[i] = -1;
            else ans[i] = dsu.and[x];
        }
        return ans;
    }

    public static class DSU {
        int[] fa;
        int[] and;

        public DSU(int n) {
            fa = new int[n];
            and = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                and[i] = -1;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }
}
/*
3108. 带权图里旅途的最小代价
https://leetcode.cn/problems/minimum-cost-walk-in-weighted-graph/description/

第 392 场周赛 T4。

给你一个 n 个节点的带权无向图，节点编号为 0 到 n - 1 。
给你一个整数 n 和一个数组 edges ，其中 edges[i] = [ui, vi, wi] 表示节点 ui 和 vi 之间有一条权值为 wi 的无向边。
在图中，一趟旅途包含一系列节点和边。旅途开始和结束点都是图中的节点，且图中存在连接旅途中相邻节点的边。注意，一趟旅途可能访问同一条边或者同一个节点多次。
如果旅途开始于节点 u ，结束于节点 v ，我们定义这一趟旅途的 代价 是经过的边权按位与 AND 的结果。换句话说，如果经过的边对应的边权为 w0, w1, w2, ..., wk ，那么代价为w0 & w1 & w2 & ... & wk ，其中 & 表示按位与 AND 操作。
给你一个二维数组 query ，其中 query[i] = [si, ti] 。对于每一个查询，你需要找出从节点开始 si ，在节点 ti 处结束的旅途的最小代价。如果不存在这样的旅途，答案为 -1 。
返回数组 answer ，其中 answer[i] 表示对于查询 i 的 最小 旅途代价。
提示：
1 <= n <= 10^5
0 <= edges.length <= 10^5
edges[i].length == 3
0 <= ui, vi <= n - 1
ui != vi
0 <= wi <= 10^5
1 <= query.length <= 10^5
query[i].length == 2
0 <= si, ti <= n - 1

脑筋急转弯 + 并查集。
由于一趟旅途可能访问同一条边或者同一个节点多次。因此将连通块内所有值 & 起来即可。
时间复杂度 O((n+m+q)logn)。
空间复杂度 O(n)。
 */
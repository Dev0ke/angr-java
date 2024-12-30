public class SolutionP261 {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return dsu.sz == 1;
    }

    private static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return true;
            }
            fa[rootQ] = rootP;
            sz--;
            return false;
        }
    }
}
/*
$261. 以图判树
https://leetcode.cn/problems/graph-valid-tree/

给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间存在一条无向边。
如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。
提示：
1 <= n <= 2000
0 <= edges.length <= 5000
edges[i].length == 2
0 <= ai, bi < n
ai != bi
不存在自循环或重复的边

并查集。
问题等价于：每条边的两个点在连接之前比不可能联通，且最终的联通分量要恰好等于 1。
 */
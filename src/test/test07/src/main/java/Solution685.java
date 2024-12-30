public class Solution685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        // parent[i] 记录节点 i 的父节点
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 冲突（即导致一个节点有两个父节点）
        int conflict = -1;
        int cycle = -1;
        DSU dsu = new DSU(n + 1);
        for (int i = 0; i < n; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            // to 有两个父节点
            if (parent[to] != to) {
                conflict = i;
            } else {
                parent[to] = from;
                if (dsu.find(from) == dsu.find(to)) {
                    cycle = i;
                } else {
                    dsu.union(from, to);
                }
            }
        }

        if (conflict == -1) {
            return edges[cycle];
        } else {
            if (cycle >= 0) {
                return new int[]{parent[edges[conflict][1]], edges[conflict][1]};
            } else {
                return edges[conflict];
            }
        }
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
        }
    }
}
/*
685. 冗余连接 II
https://leetcode.cn/problems/redundant-connection-ii/

在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
提示：
n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ui, vi <= n

并查集。
难度升级，由无向图变成有向图。
即在多了一条附加的边之后，可能有以下两种情况：
- 附加的边指向根节点，则包括根节点在内的每个节点都有一个父节点，此时图中一定有环路；
- 附加的边指向非根节点，则恰好有一个节点（即被附加的边指向的节点）有两个父节点，此时图中可能有环路也可能没有环路。
相似题目: 684. 冗余连接
https://leetcode.cn/problems/redundant-connection/
 */
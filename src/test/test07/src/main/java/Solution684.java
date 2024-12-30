public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DSU dsu = new DSU(n + 1);
        for (int[] edge : edges) {
            if (dsu.find(edge[0]) == dsu.find(edge[1])) {
                return edge;
            } else {
                dsu.union(edge[0], edge[1]);
            }
        }
        return new int[0];
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
684. 冗余连接
https://leetcode.cn/problems/redundant-connection/

树可以看成是一个连通且 无环 的 无向 图。
给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
提示:
n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
edges 中无重复元素
给定的图是连通的 

并查集。
如果有多个答案，则返回数组 edges 中最后出现的边。即遇到同一个联通分量的边返回即可。
相似题目: 685. 冗余连接 II
https://leetcode.cn/problems/redundant-connection-ii/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2421 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;

        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> vals[o]));

        // 并查集
        DSU dsu = new DSU(n);
        int res = 0;
        for (int x : ids) {
            int xVal = vals[x];
            int xFa = dsu.find(x);

            for (int y : g[x]) {
                y = dsu.find(y);
                int yVal = vals[y];
                if (y == xFa || yVal > xVal) {
                    continue;
                }
                if (yVal == xVal) {
                    res += dsu.sz[xFa] * dsu.sz[y];
                    dsu.sz[xFa] += dsu.sz[y];
                }
                dsu.fa[y] = xFa;
            }
        }
        return res + n;
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = new int[n];
            Arrays.fill(sz, 1);
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
2421. 好路径的数目
https://leetcode.cn/problems/number-of-good-paths/

第 312 场周赛 T4。

给你一棵 n 个节点的树（连通无向无环的图），节点编号从 0 到 n - 1 且恰好有 n - 1 条边。
给你一个长度为 n 下标从 0 开始的整数数组 vals ，分别表示每个节点的值。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
一条 好路径 需要满足以下条件：
1.开始节点和结束节点的值 相同 。
2.开始节点和结束节点中间的所有节点值都 小于等于 开始节点的值（也就是说开始节点的值应该是路径上所有节点的最大值）。
请你返回不同好路径的数目。
注意，一条路径和它反向的路径算作 同一 路径。比方说， 0 -> 1 与 1 -> 0 视为同一条路径。单个节点也视为一条合法路径。
提示：
n == vals.length
1 <= n <= 3 * 10^4
0 <= vals[i] <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges 表示一棵合法的树。

并查集。
从节点值小的点按序联通到节点值大的点。路径数为两点联通分量的乘积。
时间复杂度 O(nlogn)
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // edge = [i, j, d] 表示 i => j 距离 d
                edges.add(List.of(i, j, manhattan(points[i], points[j])));
            }
        }

        // Kruskal 算法
        edges.sort(Comparator.comparingInt(o -> o.get(2)));
        DSU dsu = new DSU(n);
        dsu.sz = n;
        int cost = 0;
        for (List<Integer> edge : edges) {
            if (!dsu.union(edge.get(0), edge.get(1))) {
                cost += edge.get(2);
            }
        }
        if (dsu.sz != 1) {
            return -1;
        }
        return cost;
    }

    private int manhattan(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    private static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
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
1584. 连接所有点的最小费用
https://leetcode.cn/problems/min-cost-to-connect-all-points/

给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
提示：
1 <= points.length <= 1000
-10^6 <= xi, yi <= 10^6
所有点 (xi, yi) 两两不同。

最小生成树(MST)
Kruskal 算法
相似题目: 1135. 最低成本联通所有城市
https://leetcode.cn/problems/connecting-cities-with-minimum-cost/
 */
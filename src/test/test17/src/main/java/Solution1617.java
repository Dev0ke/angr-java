import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1617 {
    private List<Integer>[] g;
    private int[][] dist;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int x = p[0] - 1, y = p[1] - 1; // 下标从 0 开始
            g[x].add(y);
            g[y].add(x);
        }
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            dfs(i, -1, i);
        }

        int[] ans = new int[n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = dist[i][j];
                ans[d - 1] += dfs2(i, -1, i, j, d);
            }
        }
        return ans;
    }

    private void dfs(int x, int fa, int i) {
        for (Integer y : g[x]) {
            if (y == fa) continue;
            dist[i][y] = dist[i][x] + 1;
            dfs(y, x, i);
        }
    }

    private int dfs2(int x, int fa, int i, int j, int d) {
        int cnt = 1; // 选 x
        for (Integer y : g[x]) {
            if (y == fa) continue;
            boolean bi = dist[i][y] < d || dist[i][y] == d && y > j;
            boolean bj = dist[j][y] < d || dist[j][y] == d && y > i;
            if (bi && bj) cnt *= dfs2(y, x, i, j, d); // 每棵子树互相独立，采用乘法原理
        }
        if (dist[i][x] + dist[j][x] > d) cnt++; // x 是可选点
        return cnt;
    }
}
/*
1617. 统计子树中城市之间最大距离
https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/description/

给你 n 个城市，编号为从 1 到 n 。同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和 vi 之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。
一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。
对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。
请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。
请注意，两个城市间距离定义为它们之间需要经过的边的数目。
提示：
2 <= n <= 15
edges.length == n-1
edges[i].length == 2
1 <= ui, vi <= n
题目保证 (ui, vi) 所表示的边互不相同。

枚举直径端点 + 乘法原理。
https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/solutions/2162612/tu-jie-on3-mei-ju-zhi-jing-duan-dian-che-am2n/
时间复杂度 O(n^3)。
 */
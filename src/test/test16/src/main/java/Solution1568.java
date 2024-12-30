import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1568 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 节点重标号
        int landCount = 0;
        int[] relabel = new int[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    relabel[i * n + j] = landCount;
                    ++landCount;
                }
            }
        }
        if (landCount == 0) return 0;
        if (landCount == 1) return 1;

        // 添加图中的边
        List<Integer>[] edges = new ArrayList[landCount];
        Arrays.setAll(edges, e -> new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    for (int[] d : DIRECTIONS) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            edges[relabel[i * n + j]].add(relabel[nx * n + ny]);
                        }
                    }
                }
            }
        }

        TarjanSCC scc = new TarjanSCC(edges);
        return scc.check();
    }

    static class TarjanSCC {
        List<Integer>[] edges;
        int[] low, dfn, fa;
        int timestamp;
        int n;

        public TarjanSCC(List<Integer>[] edges) {
            this.edges = edges;
            n = edges.length;
            low = new int[n];
            Arrays.fill(low, -1);
            dfn = new int[n];
            Arrays.fill(dfn, -1);
            fa = new int[n];
            Arrays.fill(fa, -1);
            timestamp = -1;
        }

        // Tarjan 算法求解割点模板
        void getCuttingVertex(int u, int parent, List<Integer> ans) {
            low[u] = dfn[u] = ++timestamp;
            fa[u] = parent;
            int child = 0;
            boolean iscv = false;
            for (int v : edges[u]) {
                if (dfn[v] == -1) {
                    ++child;
                    getCuttingVertex(v, u, ans);
                    low[u] = Math.min(low[u], low[v]);
                    if (!iscv && parent != -1 && low[v] >= dfn[u]) {
                        ans.add(u);
                        iscv = true;
                    }
                } else if (v != fa[u]) {
                    low[u] = Math.min(low[u], dfn[v]);
                }
            }
            if (!iscv && parent == -1 && child >= 2) {
                ans.add(u);
            }
        }

        int check() {
            // cutting vertices 存储割点
            List<Integer> cvs = new ArrayList<>();
            // connected components count 存储连通分量个数
            int cccnt = 0;
            for (int i = 0; i < n; ++i) {
                if (dfn[i] == -1) {
                    ++cccnt;
                    getCuttingVertex(i, -1, cvs);
                }
            }
            // 如果连通分量个数大于 1，答案为 0
            if (cccnt > 1) {
                return 0;
            }
            // 如果存在割点，答案为 1
            if (!cvs.isEmpty()) {
                return 1;
            }
            return 2;
        }
    }
}
/*
1568. 使陆地分离的最少天数
https://leetcode.cn/problems/minimum-number-of-days-to-disconnect-island/description/

给你一个大小为 m x n ，由若干 0 和 1 组成的二维网格 grid ，其中 1 表示陆地， 0 表示水。岛屿 由水平方向或竖直方向上相邻的 1 （陆地）连接形成。
如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。
一天内，可以将 任何单个 陆地单元（1）更改为水单元（0）。
返回使陆地分离的最少天数。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 30
grid[i][j] 为 0 或 1

https://leetcode.cn/problems/minimum-number-of-days-to-disconnect-island/solutions/441162/shi-lu-di-fen-chi-de-zui-shao-tian-shu-by-leetcode/
Tarjan 算法求解无向图的割点
时间复杂度 O(mn)。
也可分类讨论。答案只可能是 0,1,2。时间复杂度 O(m^2 * n^2)。
相似题目: A. Cutting Figure
https://codeforces.com/contest/193/problem/A
1489. 找到最小生成树里的关键边和伪关键边
https://leetcode.cn/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/
 */
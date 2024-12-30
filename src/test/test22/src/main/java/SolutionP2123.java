import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SolutionP2123 {
    // MLE
    static class V1 {
        private int[][] g;
        private int n, m, dfn;
        private int[] pa, pb, vis;

        // ((300^2)/2)^2
        // O(nm) = 45000 * 45000 = 2,025,000,000
        public int minimumOperations(int[][] grid) {
            List<int[]> points_odd = new ArrayList<>();
            List<int[]> points_even = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) continue;
                    if ((i + j) % 2 == 0) {
                        points_odd.add(new int[]{i, j});
                    } else {
                        points_even.add(new int[]{i, j});
                    }
                }
            }

            n = points_odd.size();
            m = points_even.size();
            g = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int[] p = points_odd.get(i);
                    int[] q = points_even.get(j);
                    if (Math.abs(p[0] - q[0]) + Math.abs(p[1] - q[1]) == 1) {
                        g[i][j] = 1;
                    }
                }
            }

            dfn = 0;
            pa = new int[n];
            Arrays.fill(pa, -1);
            pb = new int[m];
            Arrays.fill(pb, -1);
            vis = new int[n];

            int res = 0;
            while (true) {
                dfn++;
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (pa[i] == -1 && dfs(i)) {
                        cnt++;
                    }
                }
                if (cnt == 0) {
                    break;
                }
                res += cnt;
            }
            return res;
        }

        private boolean dfs(int x) {
            vis[x] = dfn;
            for (int y = 0; y < m; y++) {
                if (g[x][y] == 0) continue;
                if (pb[y] == -1) {
                    pb[y] = x;
                    pa[x] = y;
                    return true;
                }
            }
            for (int y = 0; y < m; y++) {
                if (g[x][y] == 0) continue;
                if (vis[pb[y]] != dfn && dfs(pb[y])) {
                    pa[x] = y;
                    pb[y] = x;
                    return true;
                }
            }
            return false;
        }
    }

    // 网络流
    static class V2 {
        public int minimumOperations(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int id = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) grid[i][j] = id++;
                }
            }

            int S = id++;
            int T = id++;
            MaxFlow mf = new MaxFlow(S, T);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) continue;
                    int x = grid[i][j];
                    if (i - 1 >= 0 && grid[i - 1][j] > 0) {
                        int y = grid[i - 1][j];
                        // 偶数到奇数连 1
                        if ((i + j) % 2 == 0) mf.add(x, y, 1);
                        else mf.add(y, x, 1);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] > 0) {
                        int y = grid[i][j - 1];
                        // 偶数到奇数连 1
                        if ((i + j) % 2 == 0) mf.add(x, y, 1);
                        else mf.add(y, x, 1);
                    }
                    // 超级源点到偶数点连 1，奇数点到超级汇点连 1
                    if ((i + j) % 2 == 0) mf.add(S, x, 1);
                    else mf.add(x, T, 1);
                }
            }
            return (int) mf.maxflow();
        }

        static class MaxFlow {
            int inf = 1 << 29, N = 100010, M = 600010;
            int[] head = new int[N], ver = new int[M], edge = new int[M], Next = new int[M], d = new int[N];
            int n, m, s, t, tot;
            long maxflow;
            Queue<Integer> q;

            public MaxFlow(int s, int t) {
                this.s = s;
                this.t = t;
                this.tot = 1;
            }

            void add(int x, int y, int z) {
                ver[++tot] = y;
                edge[tot] = z;
                Next[tot] = head[x];
                head[x] = tot;

                ver[++tot] = x;
                edge[tot] = 0;
                Next[tot] = head[y];
                head[y] = tot;
            }

            boolean bfs() { // 在残量网络上构造分层图
                Arrays.fill(d, 0);
                while (!q.isEmpty()) q.remove();
                q.add(s);
                d[s] = 1;
                while (!q.isEmpty()) {
                    int x = q.remove();
                    for (int i = head[x]; i != 0; i = Next[i]) {
                        if (edge[i] != 0 && d[ver[i]] == 0) {
                            q.add(ver[i]);
                            d[ver[i]] = d[x] + 1;
                            if (ver[i] == t) return true;
                        }
                    }
                }
                return false;
            }

            int dinic(int x, int flow) { // 在当前分层图上增广
                if (x == t) return flow;
                int rest = flow, k;
                for (int i = head[x]; i != 0 && rest != 0; i = Next[i]) {
                    if (edge[i] != 0 && d[ver[i]] == d[x] + 1) {
                        k = dinic(ver[i], Math.min(rest, edge[i]));
                        if (k == 0) d[ver[i]] = 0; // 剪枝，去掉增广完毕的点
                        edge[i] -= k;
                        edge[i ^ 1] += k;
                        rest -= k;
                    }
                }
                return flow - rest;
            }

            long maxflow() {
                q = new ArrayDeque<>();
                long flow;
                while (bfs()) {
                    while ((flow = dinic(s, inf)) != 0) maxflow += flow;
                }
                return maxflow;
            }
        }
    }
}
/*
$2123. 使矩阵中的 1 互不相邻的最小操作数
https://leetcode.cn/problems/minimum-operations-to-remove-adjacent-ones-in-matrix/description/

给你一个 下标从 0 开始 的矩阵 grid。每次操作，你可以把 grid 中的 一个 1 变成 0 。
如果一个矩阵中，没有 1 与其它的 1 四连通（也就是说所有 1 在上下左右四个方向上不能与其他 1 相邻），那么该矩阵就是 完全独立 的。
请返回让 grid 成为 完全独立 的矩阵的 最小操作数。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 是 0 或者 1.

直接套 二分图最大匹配 会 TLE。
需要用到最大流。
相似题目: $1820. 最多邀请的个数
https://leetcode.cn/problems/maximum-number-of-accepted-invitations/
 */
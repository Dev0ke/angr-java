import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2850 {
    static class V1 {
        public int minimumMoves(int[][] grid) {
            int n = grid.length;
            List<int[]> x = new ArrayList<>();
            List<int[]> y = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 1; k < grid[i][j]; k++) {
                        x.add(new int[]{i, j});
                    }
                    if (grid[i][j] == 0) {
                        y.add(new int[]{i, j});
                    }
                }
            }
            int sz = x.size();
            int[][] score = new int[sz][sz];
            for (int i = 0; i < sz; i++) {
                for (int j = 0; j < sz; j++) {
                    score[i][j] = -manhattan(x.get(i), y.get(j));
                }
            }
            KmAlgo kmAlgo = new KmAlgo(sz, score);
            return -kmAlgo.getMaximumWeight();
        }

        private int manhattan(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        private static class KmAlgo {
            private final int n;
            // 左集合对应的匹配点
            private final int[] matchX;
            // 右集合对应的匹配点
            private final int[] matchY;
            // 连接右集合的左点
            private final int[] pre;
            // 拜访数组 左
            private final boolean[] visX;
            // 拜访数组 右
            private final boolean[] visY;
            // 可行顶标 给每个节点 i 分配一个权值 l(i)，对于所有边 (u,v) 满足 w(u,v) <= l(u) + l(v)。
            private final int[] lx;
            private final int[] ly;
            private final int[][] graph;
            private final int[] slack;
            private static final int INF = Integer.MAX_VALUE;
            private final Queue<Integer> queue;

            public KmAlgo(int n, int[][] graph) {
                this.n = n;
                this.graph = graph;
                this.queue = new LinkedList<>();
                this.matchX = new int[n];
                Arrays.fill(matchX, -1);
                this.matchY = new int[n];
                Arrays.fill(matchY, -1);
                this.pre = new int[n];
                this.visX = new boolean[n];
                this.visY = new boolean[n];
                this.lx = new int[n];
                Arrays.fill(lx, -INF);
                this.ly = new int[n];
                this.slack = new int[n];
            }

            public int getMaximumWeight() {
                // 初始顶标
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        lx[i] = Math.max(lx[i], graph[i][j]);
                    }
                }
                for (int i = 0; i < n; i++) {
                    Arrays.fill(slack, INF);
                    Arrays.fill(visX, false);
                    Arrays.fill(visY, false);
                    bfs(i);
                }
                // custom
                int res = 0;
                for (int i = 0; i < n; i++) {
                    res += graph[i][matchX[i]];
                }
                return res;
            }

            private boolean check(int v) {
                visY[v] = true;
                if (matchY[v] != -1) {
                    queue.add(matchY[v]);
                    // in S
                    visX[matchY[v]] = true;
                    return false;
                }
                // 找到新的未匹配点 更新匹配点 pre 数组记录着"非匹配边"上与之相连的点
                while (v != -1) {
                    matchY[v] = pre[v];
                    // swap(v, matchx[pre[v]]);
                    int tmp = matchX[pre[v]];
                    matchX[pre[v]] = v;
                    v = tmp;
                }
                return true;
            }

            private void bfs(int i) {
                queue.clear();
                queue.add(i);
                visX[i] = true;
                while (true) {
                    while (!queue.isEmpty()) {
                        int u = queue.remove();
                        for (int v = 0; v < n; v++) {
                            if (!visY[v]) {
                                int delta = lx[u] + ly[v] - graph[u][v];
                                if (slack[v] >= delta) {
                                    pre[v] = u;
                                    if (delta > 0) {
                                        slack[v] = delta;
                                    } else if (check(v)) {
                                        // delta=0 代表有机会加入相等子图 找增广路
                                        // 找到就return 重建交错树
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    // 没有增广路 修改顶标
                    int a = INF;
                    for (int j = 0; j < n; j++) {
                        if (!visY[j]) {
                            a = Math.min(a, slack[j]);
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        // S
                        if (visX[j]) {
                            lx[j] -= a;
                        }
                        // T
                        if (visY[j]) {
                            ly[j] += a;
                        }
                        // T'
                        else {
                            slack[j] -= a;
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        if (!visY[j] && slack[j] == 0 && check(j)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    static class V2 {
        public int minimumMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            S = m * n; // 超级源点
            T = S + 1; // 超级汇点
            init();
            for (int x = 0; x < m; ++x) {
                for (int y = 0; y < n; ++y) {
                    if (grid[x][y] > 1) {
                        add_edge(S, x * n + y, grid[x][y] - 1, 0);
                        for (int i = 0; i < m; ++i) {
                            for (int j = 0; j < n; ++j) {
                                if (grid[i][j] == 0) {
                                    add_edge(x * n + y, i * n + j, 1, Math.abs(x - i) + Math.abs(y - j));
                                }
                            }
                        }
                    } else if (grid[x][y] == 0) {
                        add_edge(x * n + y, T, 1, 0);
                    }
                }
            }
            while (spfa()) update(); // 计算最大费用最大流
            return ans;
        }

        private void init() {
            tot = 1;
            maxflow = 0;
            ans = 0;
            Arrays.fill(head, 0);
        }

        static int N = 15, M = 150;
        static int[] ver = new int[M], edge = new int[M], cost = new int[M], next = new int[M], head = new int[N];
        static int[] dis = new int[N], incf = new int[N], pre = new int[N], vis = new int[N];
        static int tot, S, T;
        static int INF = (int) 1e9;
        static int maxflow, ans;

        static void add_edge(int x, int y, int z, int c) {
            // 正向边，初始容量 z，单位费用 c
            ver[++tot] = y;
            edge[tot] = z;
            cost[tot] = c;
            next[tot] = head[x];
            head[x] = tot;
            // 反向边，初始容量 0，单位费用 -c，与正向边 成对存储
            ver[++tot] = x;
            edge[tot] = 0;
            cost[tot] = -c;
            next[tot] = head[y];
            head[y] = tot;
        }

        static boolean spfa() {
            Queue<Integer> q = new ArrayDeque<>();
            Arrays.fill(dis, INF);
            q.add(S);
            dis[S] = 0;
            vis[S] = 1; // SPFA 求最长路
            incf[S] = INF; // 增广路上各边的最小剩余容量
            while (!q.isEmpty()) {
                int x = q.remove();
                vis[x] = 0;

                for (int i = head[x]; i != 0; i = next[i]) {
                    int y = ver[i];
                    if (edge[i] == 0) continue; // 剩余容量为 0，不在残量网络中，不遍历

                    if (dis[y] > dis[x] + cost[i]) {
                        dis[y] = dis[x] + cost[i];
                        incf[y] = Math.min(incf[x], edge[i]);
                        pre[y] = i; // 记录前驱，便于找到最长路的实际方案
                        if (vis[y] == 0) {
                            vis[y] = 1;
                            q.add(y);
                        }
                    }
                }
            }
            return dis[T] != INF; // 汇点不可达，已求出最大流
        }

        static void update() {
            int x = T;
            while (x != S) {
                int i = pre[x];
                edge[i] -= incf[T];
                edge[i ^ 1] += incf[T]; // 利用 成对存储 的 xor 1 技巧
                x = ver[i ^ 1];
            }
            maxflow += incf[T];
            ans += dis[T] * incf[T];
        }
    }
}
/*
2850. 将石头分散到网格图的最少移动次数
https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/

第 362 场周赛 T3。

给你一个大小为 3 * 3 ，下标从 0 开始的二维整数矩阵 grid ，分别表示每一个格子里石头的数目。网格图中总共恰好有 9 个石头，一个格子里可能会有 多个 石头。
每一次操作中，你可以将一个石头从它当前所在格子移动到一个至少有一条公共边的相邻格子。
请你返回每个格子恰好有一个石头的 最少移动次数 。
提示：
grid.length == grid[i].length == 3
0 <= grid[i][j] <= 9
grid 中元素之和为 9 。

枚举全排列 / 二分图最小权匹配
 */
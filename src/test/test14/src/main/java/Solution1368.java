import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution1368 {
    // 1 右 2 左 3 下 4 上
    private static final int[][] DIRECTIONS = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 0-1 BFS
    public int minCost(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        Deque<int[]> deque = new ArrayDeque<>();
        int[][] dist = new int[M][N];
        for (int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        deque.addFirst(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] cur = deque.removeFirst();
                int curDist = dist[cur[0]][cur[1]];
                if (cur[0] == M - 1 && cur[1] == N - 1) {
                    return curDist;
                }

                // 1 右 2 左 3 下 4 上
                for (int idx = 1; idx <= 4; idx++) {
                    int nextM = cur[0] + DIRECTIONS[idx][0];
                    int nextN = cur[1] + DIRECTIONS[idx][1];

                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N) {
                        // 步长 0-1
                        int step = (grid[cur[0]][cur[1]] == idx) ? 0 : 1;

                        if (curDist + step < dist[nextM][nextN]) {
                            dist[nextM][nextN] = curDist + step;
                            if (step == 0) {
                                deque.addFirst(new int[]{nextM, nextN});
                            } else {
                                deque.addLast(new int[]{nextM, nextN});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    // dijkstra
    public int minCost2(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // 节点数
        int n = M * N;
        // 边数
        int m = M * N * 4;
        LinkedForwardStar adjacency = new LinkedForwardStar(n, m);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int cur = i * N + j;

                int left = (j - 1 >= 0) ? (i * N + j - 1) : -1;
                int right = (j + 1 < N) ? (i * N + j + 1) : -1;
                int top = (i - 1 >= 0) ? (i - 1) * N + j : -1;
                int bottom = (i + 1 < M) ? (i + 1) * N + j : -1;

                if (left != -1) {
                    adjacency.add(cur, left, grid[i][j] == 2 ? 0 : 1);
                }
                if (right != -1) {
                    adjacency.add(cur, right, grid[i][j] == 1 ? 0 : 1);
                }
                if (top != -1) {
                    adjacency.add(cur, top, grid[i][j] == 4 ? 0 : 1);
                }
                if (bottom != -1) {
                    adjacency.add(cur, bottom, grid[i][j] == 3 ? 0 : 1);
                }
            }
        }

        int[] dist = adjacency.dijkstra(0);
        return dist[n - 1];
    }

    private static class LinkedForwardStar {
        // n 个点
        private final int N;
        // m 条边
        private final int M;
        // 链式前向星
        private final int[] headArr;
        private final int[] edgeArr;
        private final int[] nextArr;
        private final int[] weightArr;
        private int idx;

        // 链式前向星
        public LinkedForwardStar(int n, int m) {
            this.N = n + 1;
            this.M = m + 1;
            this.headArr = new int[N];
            // 初始化链表头
            Arrays.fill(headArr, -1);
            this.edgeArr = new int[M];
            this.nextArr = new int[M];
            this.weightArr = new int[M];
            this.idx = 0;
        }

        public void add(int u, int v, int w) {
            this.edgeArr[idx] = v;
            this.nextArr[idx] = headArr[u];
            this.headArr[u] = idx;
            this.weightArr[idx] = w;
            this.idx++;
        }

        // 从 src 点出发跑 dijkstra 返回 dist[] 数组
        public int[] dijkstra(int src) {
            boolean[] visited = new boolean[N];
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            // 优先队列优化
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            minHeap.add(new int[]{src, 0});
            dist[src] = 0;

            while (!minHeap.isEmpty()) {
                int[] poll = minHeap.poll();
                int id = poll[0];

                if (visited[id]) {
                    continue;
                }
                visited[id] = true;
                for (int i = headArr[id]; i != -1; i = nextArr[i]) {
                    int j = edgeArr[i];
                    if (dist[j] > dist[id] + weightArr[i]) {
                        dist[j] = dist[id] + weightArr[i];
                        minHeap.add(new int[]{j, dist[j]});
                    }
                }
            }
            return dist;
        }
    }
}
/*
1368. 使网格图至少有一条有效路径的最小代价
https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

给你一个 m x n 的网格图 grid 。 grid 中每个格子都有一个数字，对应着从该格子出发下一步走的方向。 grid[i][j] 中的数字可能为以下几种情况：
- 1 ，下一步往右走，也就是你会从 grid[i][j] 走到 grid[i][j + 1]
- 2 ，下一步往左走，也就是你会从 grid[i][j] 走到 grid[i][j - 1]
- 3 ，下一步往下走，也就是你会从 grid[i][j] 走到 grid[i + 1][j]
- 4 ，下一步往上走，也就是你会从 grid[i][j] 走到 grid[i - 1][j]
注意网格图中可能会有 无效数字 ，因为它们可能指向 grid 以外的区域。
一开始，你会从最左上角的格子 (0,0) 出发。我们定义一条 有效路径 为从格子 (0,0) 出发，每一步都顺着数字对应方向走，
最终在最右下角的格子 (m - 1, n - 1) 结束的路径。有效路径 不需要是最短路径 。
你可以花费 cost = 1 的代价修改一个格子中的数字，但每个格子中的数字 只能修改一次 。
请你返回让网格图至少有一条有效路径的最小代价。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 100

可以看成只有 0 和 1 权重的有向图，点的数量为 mn，边的数量不超过 4mn，从点 (0,0) 跑 dijkstra 即可。
时间复杂度 O(mnlog(mn))
另有 0-1 广度优先搜索 时间复杂度 O(mn) 参考: https://codeforces.com/blog/entry/22276
相似题目: LCP 56. 信物传送
https://leetcode.cn/problems/6UEx57/
 */
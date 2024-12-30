import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution2812 {
    private List<List<Integer>> grid;
    private int m, n;
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.grid = grid;
        m = grid.size();
        n = grid.get(0).size();

        if (grid.get(0).get(0) == 1 || grid.get(m - 1).get(n - 1) == 1) {
            return 0;
        }

        int left = 1;
        int right = Math.min(m, n) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int mid) {
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    vis[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            k++;
            if (k == mid) break;
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();

                for (int[] dir : DIRECTIONS) {
                    int nx = p[0] + dir[0];
                    int ny = p[1] + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (!vis[nx][ny]) {
                            vis[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        DSU dsu = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    for (int[] dir : DIRECTIONS) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n
                                && !vis[nx][ny]) {
                            dsu.union(i * n + j, nx * n + ny);
                        }
                    }
                }
            }
        }
        return dsu.find(0) == dsu.find(m * n - 1);
    }

    public int maximumSafenessFactor2(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        // 多源 BFS O(mn)
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }
        List<int[]> queue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        List<List<int[]>> groups = new ArrayList<>();
        groups.add(queue);
        while (!queue.isEmpty()) {
            List<int[]> tmp = new ArrayList<>(queue);
            queue = new ArrayList<>();
            for (int[] tuple : tmp) {
                int cx = tuple[0], cy = tuple[1];
                int nstep = tuple[2] + 1;

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (dist[nx][ny] == -1) {
                            dist[nx][ny] = nstep;
                            queue.add(new int[]{nx, ny, nstep});
                        }
                    }
                }
            }
            groups.add(queue);
        }

        DSU dsu = new DSU(m * n);
        for (int ans = groups.size() - 2; ans > 0; ans--) {
            for (int[] tuple : groups.get(ans)) {
                int cx = tuple[0], cy = tuple[1];
                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (dist[nx][ny] >= dist[cx][cy]) {
                            dsu.union(nx * n + ny, cx * n + cy);
                        }
                    }
                }
            }
            if (dsu.find(0) == dsu.find(m * n - 1)) {
                return ans;
            }
        }
        return 0;
    }

    private static class DSU {
        int[] fa;

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

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
2812. 找出最安全路径
https://leetcode.cn/problems/find-the-safest-path-in-a-grid/

第 357 场周赛 T3。

给你一个下标从 0 开始、大小为 n x n 的二维矩阵 grid ，其中 (r, c) 表示：
- 如果 grid[r][c] = 1 ，则表示一个存在小偷的单元格
- 如果 grid[r][c] = 0 ，则表示一个空单元格
你最开始位于单元格 (0, 0) 。在一步移动中，你可以移动到矩阵中的任一相邻单元格，包括存在小偷的单元格。
矩阵中路径的 安全系数 定义为：从路径中任一单元格到矩阵中任一小偷所在单元格的 最小 曼哈顿距离。
返回所有通向单元格 (n - 1, n - 1) 的路径中的 最大安全系数 。
单元格 (r, c) 的某个 相邻 单元格，是指在矩阵中存在的 (r, c + 1)、(r, c - 1)、(r + 1, c) 和 (r - 1, c) 之一。
两个单元格 (a, b) 和 (x, y) 之间的 曼哈顿距离 等于 | a - x | + | b - y | ，其中 |val| 表示 val 的绝对值。
提示：
1 <= grid.length == n <= 400
grid[i].length == n
grid[i][j] 为 0 或 1
grid 至少存在一个小偷

二分 + 多源BFS + DSU判定 / 多源BFS + DSU贪心
411ms / 110ms
 */
import java.util.LinkedList;
import java.util.Queue;

public class Solution1254 {
    public static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private int m, n;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        // “水淹” 所有边缘的 土地
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) bfs(i, 0);
            if (grid[i][n - 1] == 0) bfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) bfs(0, j);
            if (grid[m - 1][j] == 0) bfs(m - 1, j);
        }

        // Same as Solution200
        DSU dsu = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dsu.sz++;

                    for (int[] dir : DIRECTIONS) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n
                                && grid[nx][ny] == 0) {
                            dsu.union(i * n + j, nx * n + ny);
                        }
                    }
                }
            }
        }
        return dsu.sz;
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1];
                grid[cx][cy] = 1;

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n
                            && grid[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
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

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
            sz--;
        }
    }
}
/*
1254. 统计封闭岛屿的数目
https://leetcode.cn/problems/number-of-closed-islands/

二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
请返回 封闭岛屿 的数目。
提示：
1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1

并查集 + BFS
先将与矩阵边缘联通的 0 全部转成 1，其余同 岛屿数量。
相似题目: 200. 岛屿数量
https://leetcode.cn/problems/number-of-islands/
1020. 飞地的数量
https://leetcode.cn/problems/number-of-enclaves/
 */
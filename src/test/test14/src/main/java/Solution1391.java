public class Solution1391 {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 分配 id
        int[][] up = new int[m][n];
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int id = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = id++;
                right[i][j] = id++;
                down[i][j] = id++;
                left[i][j] = id++;
            }
        }
        int S = id++;
        int T = id++;

        DSU dsu = new DSU(id);
        dsu.union(S, up[0][0]);
        dsu.union(S, right[0][0]);
        dsu.union(S, down[0][0]);
        dsu.union(S, left[0][0]);

        dsu.union(up[m - 1][n - 1], T);
        dsu.union(right[m - 1][n - 1], T);
        dsu.union(down[m - 1][n - 1], T);
        dsu.union(left[m - 1][n - 1], T);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int street = grid[i][j];
                // 连通上下
                if (i > 0 && (street == 2 || street == 5 || street == 6)) {
                    dsu.union(down[i - 1][j], up[i][j]);
                }
                // 连通左右
                if (j > 0 && (street == 1 || street == 3 || street == 5)) {
                    dsu.union(right[i][j - 1], left[i][j]);
                }
                // 连通内部
                if (street == 1) {
                    dsu.union(left[i][j], right[i][j]);
                } else if (street == 2) {
                    dsu.union(up[i][j], down[i][j]);
                } else if (street == 3) {
                    dsu.union(left[i][j], down[i][j]);
                } else if (street == 4) {
                    dsu.union(right[i][j], down[i][j]);
                } else if (street == 5) {
                    dsu.union(left[i][j], up[i][j]);
                } else {
                    dsu.union(right[i][j], up[i][j]);
                }
            }
        }
        return dsu.find(S) == dsu.find(T);
    }

    static class DSU {
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

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            fa[x] = y;
        }
    }
}
/*
1391. 检查网格中是否存在有效路径
https://leetcode.cn/problems/check-if-there-is-a-valid-path-in-a-grid/description/

给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
- 1 表示连接左单元格和右单元格的街道。
- 2 表示连接上单元格和下单元格的街道。
- 3 表示连接左单元格和下单元格的街道。
- 4 表示连接右单元格和下单元格的街道。
- 5 表示连接左单元格和上单元格的街道。
- 6 表示连接右单元格和上单元格的街道。
你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
注意：你 不能 变更街道。
如果网格中存在有效的路径，则返回 true，否则返回 false 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
1 <= grid[i][j] <= 6

并查集。
相似题目: 959. 由斜杠划分区域
https://leetcode.cn/problems/regions-cut-by-slashes/description/
 */
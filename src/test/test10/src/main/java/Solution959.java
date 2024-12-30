public class Solution959 {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        // 分配 id
        int[][] up = new int[n][n];
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];
        int[][] left = new int[n][n];
        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = id++;
                right[i][j] = id++;
                down[i][j] = id++;
                left[i][j] = id++;
            }
        }

        DSU dsu = new DSU(id);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 连通上下
                if (i > 0) {
                    dsu.union(down[i - 1][j], up[i][j]);
                }
                // 连通左右
                if (j > 0) {
                    dsu.union(right[i][j - 1], left[i][j]);
                }
                // 连通内部
                char c = grid[i].charAt(j);
                if (c == ' ') {
                    dsu.union(up[i][j], down[i][j]);
                    dsu.union(up[i][j], left[i][j]);
                    dsu.union(up[i][j], right[i][j]);
                } else if (c == '/') {
                    dsu.union(left[i][j], up[i][j]);
                    dsu.union(down[i][j], right[i][j]);
                } else {
                    dsu.union(left[i][j], down[i][j]);
                    dsu.union(up[i][j], right[i][j]);
                }
            }
        }
        return dsu.sz;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
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
            sz--;
        }
    }
}
/*
959. 由斜杠划分区域
https://leetcode.cn/problems/regions-cut-by-slashes/description/

在由 1 x 1 方格组成的 n x n 网格 grid 中，每个 1 x 1 方块由 '/'、'\' 或空格构成。这些字符会将方块划分为一些共边的区域。
给定网格 grid 表示为一个字符串数组，返回 区域的数量 。
请注意，反斜杠字符是转义的，因此 '\' 用 '\\' 表示。
提示：
n == grid.length == grid[i].length
1 <= n <= 30
grid[i][j] 是 '/'、'\'、或 ' '

并查集。
相似题目: LCP 71. 集水器
https://leetcode.cn/problems/kskhHQ/
1391. 检查网格中是否存在有效路径
https://leetcode.cn/problems/check-if-there-is-a-valid-path-in-a-grid/description/
 */
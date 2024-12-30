public class Solution1559 {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        DSU dsu = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && grid[i - 1][j] == grid[i][j]) {
                    if (dsu.union((i - 1) * n + j, i * n + j)) {
                        return true;
                    }
                }
                if (j - 1 >= 0 && grid[i][j - 1] == grid[i][j]) {
                    if (dsu.union(i * n + (j - 1), i * n + j)) {
                        return true;
                    }
                }
            }
        }
        return false;
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
            if (x != fa[x]) fa[x] = find(fa[x]);
            return fa[x];
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return true;
            fa[x] = y;
            return false;
        }
    }
}
/*
1559. 二维网格图中探测环
https://leetcode.cn/problems/detect-cycles-in-2d-grid/description/

给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。
同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。
如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
提示：
m == grid.length
n == grid[i].length
1 <= m <= 500
1 <= n <= 500
grid 只包含小写英文字母。

并查集。
时间复杂度 O(mnlog(mn))
 */
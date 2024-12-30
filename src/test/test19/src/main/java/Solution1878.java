public class Solution1878 {
    private int[][] ds, as; // 主对角线方向前缀和，副对角线方向前缀和
    private int x, y, z; // 最大，严格次大，严格第三大

    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ds = new int[n + 1][m + 1];
        as = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                ds[i + 1][j + 1] = ds[i][j] + v; // ↘
                as[i + 1][j] = as[i][j + 1] + v; // ↙
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                update(v);
                for (int k = 1; k <= i && i + k < n && k <= j && j + k < m; k++) {
                    int a = queryDiagonal(i - k, j, k); // 菱形右上
                    int b = queryAntiDiagonal(i - k + 1, j - 1, k - 1); // 菱形左上
                    int c = queryDiagonal(i, j - k, k); // 菱形左下
                    int d = queryAntiDiagonal(i, j + k, k + 1); // 菱形右下
                    update(a + b + c + d);
                }
            }
        }
        if (z == 0) return y == 0 ? new int[]{x} : new int[]{x, y};
        return new int[]{x, y, z};
    }

    private void update(int v) {
        if (v > x) {
            z = y;
            y = x;
            x = v;
        } else if (v < x && v > y) {
            z = y;
            y = v;
        } else if (v < y && v > z) {
            z = v;
        }
    }

    // 从 (x,y) 开始，向 ↘，连续的 k 个数的和
    private int queryDiagonal(int x, int y, int k) {
        return ds[x + k][y + k] - ds[x][y];
    }

    // 从 (x,y) 开始，向 ↙，连续的 k 个数的和
    private int queryAntiDiagonal(int x, int y, int k) {
        return as[x + k][y + 1 - k] - as[x][y + 1];
    }
}
/*
1878. 矩阵中最大的三个菱形和
https://leetcode.cn/problems/get-biggest-three-rhombus-sums-in-a-grid/description/

给你一个 m x n 的整数矩阵 grid 。
菱形和 指的是 grid 中一个正菱形 边界 上的元素之和。本题中的菱形必须为正方形旋转45度，且四个角都在一个格子当中。下图是四个可行的菱形，每个菱形和应该包含的格子都用了相应颜色标注在图中。
注意，菱形可以是一个面积为 0 的区域，如上图中右下角的紫色菱形所示。
请你按照 降序 返回 grid 中三个最大的 互不相同的菱形和 。如果不同的和少于三个，则将它们全部返回。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 100
1 <= grid[i][j] <= 10^5

斜向前缀和。
时间复杂度 O(mn * min(m,n))。
 */
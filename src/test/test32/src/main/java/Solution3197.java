public class Solution3197 {
    public int minimumSum(int[][] grid) {
        return Math.min(f(grid), f(rotate(grid)));
    }

    private int f(int[][] a) {
        int ans = Integer.MAX_VALUE;
        int m = a.length;
        int n = a[0].length;
        if (m >= 3) {
            for (int i = 1; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    // 图片上左（上中下）
                    int area = minimumArea(a, 0, i, 0, n);
                    area += minimumArea(a, i, j, 0, n);
                    area += minimumArea(a, j, m, 0, n);
                    ans = Math.min(ans, area);
                }
            }
        }
        if (m >= 2 && n >= 2) {
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // 图片上中（上左右）
                    int area = minimumArea(a, 0, i, 0, n);
                    area += minimumArea(a, i, m, 0, j);
                    area += minimumArea(a, i, m, j, n);
                    ans = Math.min(ans, area);
                    // 图片上右（左右下）
                    area = minimumArea(a, 0, i, 0, j);
                    area += minimumArea(a, 0, i, j, n);
                    area += minimumArea(a, i, m, 0, n);
                    ans = Math.min(ans, area);
                }
            }
        }
        return ans;
    }

    private int minimumArea(int[][] a, int u, int d, int l, int r) {
        int left = a[0].length;
        int right = 0;
        int up = a.length;
        int down = 0;
        for (int i = u; i < d; i++) {
            for (int j = l; j < r; j++) {
                if (a[i][j] == 1) {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    up = Math.min(up, i);
                    down = i;
                }
            }
        }
        return (right - left + 1) * (down - up + 1);
    }

    private int[][] rotate(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] b = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[j][m - 1 - i] = a[i][j];
            }
        }
        return b;
    }
}
/*
3197. 包含所有 1 的最小矩形面积 II
https://leetcode.cn/problems/find-the-minimum-area-to-cover-all-ones-ii/description/

第 403 场周赛 T4。

给你一个二维 二进制 数组 grid。你需要找到 3 个 不重叠、面积 非零 、边在水平方向和竖直方向上的矩形，并且满足 grid 中所有的 1 都在这些矩形的内部。
返回这些矩形面积之和的 最小 可能值。
注意，这些矩形可以相接。
提示：
1 <= grid.length, grid[i].length <= 30
grid[i][j] 是 0 或 1。
输入保证 grid 中至少有三个 1 。

分类讨论 6 种情况，
上中下、上左右、左右下
左中右、上下右、左上下
时间复杂度 O(m^2 n^2)。
rating 2565 (clist.by)
相似题目: F - Non-overlapping Squares
https://atcoder.jp/contests/abc347/tasks/abc347_f
 */
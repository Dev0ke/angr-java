public class Solution3212 {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        // 二维前缀和
        int[][] ps2d_x = new int[n + 1][m + 1];
        int[][] ps2d_xy = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int v_x = grid[i - 1][j - 1] == 'X' ? 1 : 0;
                ps2d_x[i][j] = ps2d_x[i - 1][j] + ps2d_x[i][j - 1] - ps2d_x[i - 1][j - 1] + v_x;

                int v_xy = 0;
                if (grid[i - 1][j - 1] == 'X') v_xy = 1;
                else if (grid[i - 1][j - 1] == 'Y') v_xy = -1;
                ps2d_xy[i][j] = ps2d_xy[i - 1][j] + ps2d_xy[i][j - 1] - ps2d_xy[i - 1][j - 1] + v_xy;

                if (ps2d_x[i][j] > 0 && ps2d_xy[i][j] == 0) ans++;
            }
        }
        return ans;
    }
}
/*
3212. 统计 X 和 Y 频数相等的子矩阵数量
https://leetcode.cn/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/

第 405 场周赛 T3。

给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的 子矩阵 数量：
- 包含 grid[0][0]
- 'X' 和 'Y' 的频数相等。
- 至少包含一个 'X'。
提示：
1 <= grid.length, grid[i].length <= 1000
grid[i][j] 可能是 'X'、'Y' 或 '.'.

二维前缀和。
时间复杂度 O(nm)。
 */
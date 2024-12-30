public class Solution3127 {
    public boolean canMakeSquare(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int sum = val(grid[i - 1][j - 1]) + val(grid[i - 1][j]) + val(grid[i][j - 1]) + val(grid[i][j]);
                if (sum != 2) return true;
            }
        }
        return false;
    }

    private int val(char c) {
        return c == 'B' ? 1 : 0;
    }
}
/*
3127. 构造相同颜色的正方形
https://leetcode.cn/problems/make-a-square-with-the-same-color/description/

第 129 场双周赛 T1。

给你一个二维 3 x 3 的矩阵 grid ，每个格子都是一个字符，要么是 'B' ，要么是 'W' 。字符 'W' 表示白色，字符 'B' 表示黑色。
你的任务是改变 至多一个 格子的颜色，使得矩阵中存在一个 2 x 2 颜色完全相同的正方形。
如果可以得到一个相同颜色的 2 x 2 正方形，那么返回 true ，否则返回 false 。
提示：
grid.length == 3
grid[i].length == 3
grid[i][j] 要么是 'W' ，要么是 'B' 。

枚举，将 'B' 看作 1，当 2*2 格子和为 2 时不满足。
时间复杂度 O(1)。
 */
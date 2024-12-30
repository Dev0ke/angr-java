public class Solution3195 {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mnI = n, mxI = 0, mnJ = m, mxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    mnI = Math.min(mnI, i);
                    mxI = Math.max(mxI, i);

                    mnJ = Math.min(mnJ, j);
                    mxJ = Math.max(mxJ, j);
                }
            }
        }
        return (mxI - mnI + 1) * (mxJ - mnJ + 1);
    }
}
/*
3195. 包含所有 1 的最小矩形面积 I
https://leetcode.cn/problems/find-the-minimum-area-to-cover-all-ones-i/description/

第 403 场周赛 T2。

给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
返回这个矩形可能的 最小 面积。
提示：
1 <= grid.length, grid[i].length <= 1000
grid[i][j] 是 0 或 1。
输入保证 grid 中至少有一个 1 。

找边界。
时间复杂度 O(mn)。
 */
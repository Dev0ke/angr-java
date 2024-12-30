public class Solution892 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 先把 grid[i][j] 赋值给 lvl，省掉了 bound check，可以略微略微略微优化一下耗时。。。
                int lvl = grid[i][j];
                if (lvl > 0) {
                    // 一个柱体中：2个底面 + 所有的正方体都贡献了4个侧表面积
                    area += lvl * 4 + 2;
                    // 减掉 i 与 i-1 相贴的两份表面积
                    if (i - 1 >= 0) area -= Math.min(lvl, grid[i - 1][j]) * 2;
                    // 减掉 j 与 j-1 相贴的两份表面积
                    if (j - 1 >= 0) area -= Math.min(lvl, grid[i][j - 1]) * 2;
                }
            }
        }
        return area;
    }
}
/*
892. 三维形体的表面积
https://leetcode.cn/problems/surface-area-of-3d-shapes/description/

给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
请你返回最终这些形体的总表面积。
注意：每个形体的底面也需要计入表面积中。
提示：
n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] <= 50

枚举。
时间复杂度 O(n^2)。
 */
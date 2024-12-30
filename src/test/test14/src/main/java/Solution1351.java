public class Solution1351 {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt < 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
1351. 统计有序矩阵中的负数
https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/

给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？

数据量较小，直接暴力即可。
 */
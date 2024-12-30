public class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = getMax(grid, i + 1, j + 1);
            }
        }
        return res;
    }

    private int getMax(int[][] grid, int i, int j) {
        int max = 0;
        for (int a = i - 1; a <= i + 1; a++) {
            for (int b = j - 1; b <= j + 1; b++) {
                max = Math.max(max, grid[a][b]);
            }
        }
        return max;
    }
}
/*
2373. 矩阵中的局部最大值
https://leetcode.cn/problems/largest-local-values-in-a-matrix/

第 306 场周赛 T1。

给你一个大小为 n x n 的整数矩阵 grid 。
生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
- maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
返回生成的矩阵。
提示：
n == grid.length == grid[i].length
3 <= n <= 100
1 <= grid[i][j] <= 100

模拟。
时间复杂度 O(n^2) 常数为 9
 */
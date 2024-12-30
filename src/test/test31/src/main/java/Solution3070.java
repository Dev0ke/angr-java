public class Solution3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        int[][] ps2d = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + grid[i - 1][j - 1];
                if (ps2d[i][j] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
/*
3070. 元素和小于等于 k 的子矩阵的数目
https://leetcode.cn/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/

第 387 场周赛 T2。

给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。
返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵 的数目。
提示：
m == grid.length
n == grid[i].length
1 <= n, m <= 1000
0 <= grid[i][j] <= 1000
1 <= k <= 10^9

二位前缀和。
时间复杂度 O(mn)
 */
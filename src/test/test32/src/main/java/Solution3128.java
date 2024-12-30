public class Solution3128 {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] row = new long[n];
        long[] col = new long[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans += (row[i] - 1) * (col[j] - 1);
                }
            }
        }
        return ans;
    }
}
/*
3128. 直角三角形
https://leetcode.cn/problems/right-triangles/description/

第 129 场双周赛 T2。

给你一个二维 boolean 矩阵 grid 。
请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
注意：
- 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
提示：
1 <= grid.length <= 1000
1 <= grid[i].length <= 1000
0 <= grid[i][j] <= 1

枚举每个点为三角形的直角边交点。
时间复杂度 O(nm)。
 */
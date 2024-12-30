public class Solution1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        PrefixSum2d prefixSum2d = new PrefixSum2d(mat);

        int left = 0;
        int right = Math.min(mat.length, mat[0].length) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mat, threshold, prefixSum2d, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int[][] mat, int threshold, PrefixSum2d prefixSum2d, int mid) {
        int matM = mat.length;
        int matN = mat[0].length;
        for (int i = 0; i < matM - mid + 1; i++) {
            for (int j = 0; j < matN - mid + 1; j++) {
                int sum = prefixSum2d.sumRegion(i, j, i + mid - 1, j + mid - 1);
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class PrefixSum2d {
        private final int[][] preSum2d;

        public PrefixSum2d(int[][] matrix) {
            preSum2d = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < matrix.length + 1; i++) {
                for (int j = 1; j < matrix[0].length + 1; j++) {
                    preSum2d[i][j] = preSum2d[i - 1][j] + preSum2d[i][j - 1] - preSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        // 二维前缀和：求 matrix [row1,col1] 到 [row2,col2] 的累加和
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
        }
    }
}
/*
1292. 元素和小于等于阈值的正方形的最大边长
https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

第 167 场周赛 T3。

给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 300
0 <= mat[i][j] <= 10^4
0 <= threshold <= 10^5

二维前缀和 + 二分
 */
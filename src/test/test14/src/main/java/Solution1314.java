public class Solution1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int matM = mat.length;
        int matN = mat[0].length;
        int[][] answer = new int[matM][matN];
        PrefixSum2d prefixSum2d = new PrefixSum2d(mat);
        for (int i = 0; i < matM; i++) {
            for (int j = 0; j < matN; j++) {
                int row1 = Math.max(0, i - k);
                int col1 = Math.max(0, j - k);
                int row2 = Math.min(matM - 1, i + k);
                int col2 = Math.min(matN - 1, j + k);
                answer[i][j] = prefixSum2d.sumRegion(row1, col1, row2, col2);
            }
        }
        return answer;
    }

    // 二维前缀和
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

        // 求 [row1,col1] 到 [row2,col2] 的累加和
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
        }
    }
}
/*
1314. 矩阵区域和
https://leetcode.cn/problems/matrix-block-sum/

第 17 场双周赛 T2。

给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
- i - k <= r <= i + k,
- j - k <= c <= j + k 且
- (r, c) 在矩阵内。
提示：
m == mat.length
n == mat[i].length
1 <= m, n, k <= 100
1 <= mat[i][j] <= 100
 */
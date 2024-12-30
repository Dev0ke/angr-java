public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        // 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
        boolean[] zeroM = new boolean[M];
        boolean[] zeroN = new boolean[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    zeroM[i] = true;
                    zeroN[j] = true;
                }
            }
        }
        // 原地 算法
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (zeroM[i] || zeroN[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
/*
73. 矩阵置零
https://leetcode.cn/problems/set-matrix-zeroes/

给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
提示：
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31 - 1
进阶：
一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？

记录需置零的 横坐标 纵坐标。
空间复杂度 O(m + n)
*/
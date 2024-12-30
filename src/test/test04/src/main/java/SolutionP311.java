public class SolutionP311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        // int[m][k] * int[k][n]
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] res = new int[m][n];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < k; c++) {
                    res[a][b] += mat1[a][c] * mat2[c][b];
                }
            }
        }
        return res;
    }
}
/*
$311. 稀疏矩阵的乘法
https://leetcode.cn/problems/sparse-matrix-multiplication/

给定两个 稀疏矩阵 ：大小为 m x k 的稀疏矩阵 mat1 和大小为 k x n 的稀疏矩阵 mat2 ，返回 mat1 x mat2 的结果。你可以假设乘法总是可能的。
提示:
m == mat1.length
k == mat1[i].length == mat2.length
n == mat2[i].length
1 <= m, n, k <= 100
-100 <= mat1[i][j], mat2[i][j] <= 100

矩阵乘法
 */
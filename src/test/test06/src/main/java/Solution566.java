public class Solution566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int M = mat.length;
        int N = mat[0].length;

        if (M * N != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int total = i * c + j;
                res[i][j] = mat[total / N][total % N];
            }
        }
        return res;
    }
}
/*
566. 重塑矩阵
https://leetcode.cn/problems/reshape-the-matrix/

在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300

res[i][j] = mat[total / curN][total % curN]; (total = i * c + j)
 */
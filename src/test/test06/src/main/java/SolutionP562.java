public class SolutionP562 {
    public int longestLine(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int ans = 0;
        int[][] horizontal = new int[M][N];
        int[][] vertical = new int[M][N];
        int[][] diagonal = new int[M][N];
        int[][] antiDiagonal = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    horizontal[i][j] = 0;
                    vertical[i][j] = 0;
                    diagonal[i][j] = 0;
                    antiDiagonal[i][j] = 0;
                } else {
                    horizontal[i][j] = (j > 0) ? (horizontal[i][j - 1] + 1) : 1;
                    vertical[i][j] = (i > 0) ? (vertical[i - 1][j] + 1) : 1;
                    diagonal[i][j] = (i > 0 && j > 0) ? (diagonal[i - 1][j - 1] + 1) : 1;
                    antiDiagonal[i][j] = (i > 0 && j < N - 1) ? (antiDiagonal[i - 1][j + 1] + 1) : 1;

                    ans = Math.max(ans, horizontal[i][j]);
                    ans = Math.max(ans, vertical[i][j]);
                    ans = Math.max(ans, diagonal[i][j]);
                    ans = Math.max(ans, antiDiagonal[i][j]);
                }
            }
        }
        return ans;
    }
}
/*
$562. 矩阵中最长的连续1线段
https://leetcode.cn/problems/longest-line-of-consecutive-one-in-matrix/

给定一个 m x n 的二进制矩阵 mat ，返回矩阵中最长的连续1线段。
这条线段可以是水平的、垂直的、对角线的或者反对角线的。
提示:
m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
mat[i][j] 不是 0 就是 1.

二维动态规划。
时间复杂度 O(mn)
 */
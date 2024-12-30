public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        // 转置 行列数交互
        int[][] res = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
}
/*
867. 转置矩阵
https://leetcode.cn/problems/transpose-matrix/

第 92 场周赛 T1。

给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
1 2 3      1 4
4 5 6  =>  2 5
           3 6
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
-10^9 <= matrix[i][j] <= 10^9
 */
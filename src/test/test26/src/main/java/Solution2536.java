public class Solution2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        PrefixSum2d prefixSum2d = new PrefixSum2d(new int[n][n]);
        for (int[] query : queries) {
            prefixSum2d.rangeAdd(query[0], query[1], query[2], query[3], 1);
        }
        return prefixSum2d.originalArray();
    }

    private static class PrefixSum2d {
        private final int M;
        private final int N;
        private final int[][] diff2d;

        public PrefixSum2d(int[][] matrix) {
            this.M = matrix.length;
            this.N = matrix[0].length;
            diff2d = new int[M + 1][N + 1];
        }

        // 二维差分：matrix [row1,col1] 到 [row2,col2] 全部增加 inc
        public void rangeAdd(int row1, int col1, int row2, int col2, int inc) {
            diff2d[row1][col1] += inc;
            diff2d[row1][col2 + 1] -= inc;
            diff2d[row2 + 1][col1] -= inc;
            diff2d[row2 + 1][col2 + 1] += inc;
        }

        // 二维差分：获取原数组
        public int[][] originalArray() {
            int[][] res = new int[M][N];
            // 0 行
            res[0][0] = diff2d[0][0];
            for (int j = 1; j < N; j++) {
                res[0][j] = res[0][j - 1] + diff2d[0][j];
            }
            // 0 列
            for (int i = 1; i < M; i++) {
                res[i][0] = res[i - 1][0] + diff2d[i][0];
            }
            // 1 行 1 列。。。
            for (int i = 1; i < M; i++) {
                for (int j = 1; j < N; j++) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + diff2d[i][j];
                }
            }
            return res;
        }
    }
}
/*
2536. 子矩阵元素加 1
https://leetcode.cn/problems/increment-submatrices-by-one/

第 328 场周赛 T2。

给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。
另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作：
- 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。也就是给所有满足 row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。
返回执行完所有操作后得到的矩阵 mat 。
提示：
1 <= n <= 500
1 <= queries.length <= 10^4
0 <= row1i <= row2i < n
0 <= col1i <= col2i < n

二维差分模板题
时间复杂度 O(n^2 + q)
 */
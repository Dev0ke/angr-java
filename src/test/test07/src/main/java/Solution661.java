public class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        int M = img.length;
        int N = img[0].length;

        PrefixSum2d prefixSum2d = new PrefixSum2d(img);
        int[][] res = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int startI = Math.max(0, i - 1);
                int startJ = Math.max(0, j - 1);
                int endI = Math.min(M - 1, i + 1);
                int endJ = Math.min(N - 1, j + 1);
                int sum = prefixSum2d.sumRegion(startI, startJ, endI, endJ);
                int cnt = (endI - startI + 1) * (endJ - startJ + 1);
                int floor = sum / cnt;
                res[i][j] = floor;
            }
        }
        return res;
    }

    private static class PrefixSum2d {
        private final int M;
        private final int N;
        private final int[][] preSum2d;
        private final int[][] diff2d;

        public PrefixSum2d(int[][] matrix) {
            this.M = matrix.length;
            this.N = matrix[0].length;
            // 预处理前缀和
            preSum2d = new int[M + 1][N + 1];
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    // 当前格 = 上 + 左 - 左上 + 原值
                    preSum2d[i][j] = preSum2d[i - 1][j] + preSum2d[i][j - 1] - preSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            // 差分 init
            diff2d = new int[M + 1][N + 1];
        }

        // 二维前缀和：求 matrix [row1,col1] 到 [row2,col2] 的累加和
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
        }
    }
}
/*
661. 图片平滑器
https://leetcode.cn/problems/image-smoother/

图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
提示:
m == img.length
n == img[i].length
1 <= m, n <= 200
0 <= img[i][j] <= 255

二维前缀和
 */
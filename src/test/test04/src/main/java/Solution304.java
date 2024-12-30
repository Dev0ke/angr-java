public class Solution304 {
    static class NumMatrix {
        // 定义 preSum[i-1][j-1] 为 matrix[0][0] 到 matrix[i][j] 的和
        private final int[][] preSum;
        
        public NumMatrix(int[][] matrix) {
            int matrixM = matrix.length + 1;
            int matrixN = matrix[0].length + 1;
            preSum = new int[matrixM][matrixN];
            for (int i = 1; i < matrixM; i++) {
                for (int j = 1; j < matrixN; j++) {
                    // 重复加了一次 duplicate, 要减掉
                    int up = preSum[i - 1][j];
                    int left = preSum[i][j - 1];
                    // 重复
                    int duplicate = preSum[i - 1][j - 1];
                    preSum[i][j] = up + left - duplicate + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int big = preSum[row2 + 1][col2 + 1];
            int up = preSum[row1][col2 + 1];
            int left = preSum[row2 + 1][col1];
            int duplicate = preSum[row1][col1];
            // 跟构造函数逻辑相反, 重复减了一次 duplicate，要加回来
            return big - left - up + duplicate;
        }
    }
}
/*
304. 二维区域和检索 - 矩阵不可变
https://leetcode.cn/problems/range-sum-query-2d-immutable/

给定一个二维矩阵 matrix，以下类型的多个请求：
- 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
实现 NumMatrix 类：
- NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
- int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
-10^5 <= matrix[i][j] <= 10^5
0 <= row1 <= row2 < m
0 <= col1 <= col2 < n
最多调用 10^4 次 sumRegion 方法

二维前缀和
raw:
[3, 0, 1, 4, 2]
[5, 6, 3, 2, 1]
[1, 2, 0, 1, 5]
[4, 1, 0, 1, 7]
[1, 0, 3, 0, 5]
preSum:
[0, 0,  0,  0,  0,  0]
[0, 3,  3,  4,  8,  10]
[0, 8,  14, 18, 24, 27]
[0, 9,  17, 21, 28, 36]
[0, 13, 22, 26, 34, 49]
[0, 14, 23, 30, 38, 58]
 */
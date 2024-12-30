public class SolutionP308 {
    static class NumMatrix {
        private final int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public void update(int row, int col, int val) {
            matrix[row][col] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }
}
/*
$308. 二维区域和检索 - 可变
https://leetcode.cn/problems/range-sum-query-2d-mutable/

给你一个二维矩阵 matrix ，处理以下类型的多个查询:
1.更新 matrix 中单元格的值。
2.计算由 左上角 (row1, col1) 和 右下角 (row2, col2) 定义的 matrix 内矩阵元素的 和。
实现 NumMatrix 类：
- NumMatrix(int[][] matrix) 用整数矩阵 matrix 初始化对象。
- void update(int row, int col, int val) 更新 matrix[row][col] 的值到 val 。
- int sumRegion(int row1, int col1, int row2, int col2) 返回矩阵 matrix 中指定矩形区域元素的 和 ，该区域由 左上角 (row1, col1) 和 右下角 (row2, col2) 界定。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
-10^5 <= matrix[i][j] <= 10^5
0 <= row < m
0 <= col < n
-10^5 <= val <= 10^5
0 <= row1 <= row2 < m
0 <= col1 <= col2 < n
最多调用10^4 次 sumRegion 和 update 方法

暴力也能过。。离谱程度等同于 2536 题
TODO
 */
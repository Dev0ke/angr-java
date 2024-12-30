public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int up = 0;
        int right = n - 1;
        int down = n - 1;

        int cnt = 1;
        while (left <= right && up <= down) {
            // 左到右
            for (int j = left; j <= right; j++) {
                matrix[up][j] = cnt;
                cnt++;
            }
            // 上到下
            for (int i = up + 1; i <= down; i++) {
                matrix[i][right] = cnt;
                cnt++;
            }
            if (left < right && up < down) {
                // 右到左
                for (int j = right - 1; j > left; j--) {
                    matrix[down][j] = cnt;
                    cnt++;
                }
                // 下到上
                for (int i = down; i > up; i--) {
                    matrix[i][left] = cnt;
                    cnt++;
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return matrix;
    }
}
/*
59. 螺旋矩阵 II
https://leetcode.cn/problems/spiral-matrix-ii/

给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
提示：
1 <= n <= 20

模拟
相似题目: 54. 螺旋矩阵
https://leetcode.cn/problems/spiral-matrix/
 */

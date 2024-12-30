public class Solution48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // 上下翻转
        for (int i = 0; i < len / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[len - 1 - i];
            matrix[len - 1 - i] = tmp;
        }
        // 对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
/*
48. 旋转图像
https://leetcode.cn/problems/rotate-image/

给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
提示：
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

模板题。矩阵顺时针翻转 90 度
现实生活中，可以拿一个类似矩形的物体进行模拟。事实上，不一定要上下翻转（左右翻转亦可）
相似题目: 1886. 判断矩阵经轮转后是否一致
https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 */
import java.util.Arrays;

public class Solution1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            // 旋转最多执行 3 次
            rotate(mat);
        }
        return false;
    }

    private void rotate(int[][] matrix) {
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
1886. 判断矩阵经轮转后是否一致
https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation/

第 244 场周赛 T1。

给你两个大小为 n x n 的二进制矩阵 mat 和 target 。
现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
提示：
n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] 和 target[i][j] 不是 0 就是 1

矩阵旋转 90 度。
相似题目: 48. 旋转图像
https://leetcode.cn/problems/rotate-image/
 */

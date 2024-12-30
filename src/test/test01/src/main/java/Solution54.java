import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int left = 0;
        int up = 0;
        int right = N - 1;
        int down = M - 1;
        List<Integer> resList = new ArrayList<>();
        while (left <= right && up <= down) {
            // 左到右
            for (int j = left; j <= right; j++) {
                resList.add(matrix[up][j]);
            }
            // 上到下
            for (int i = up + 1; i <= down; i++) {
                resList.add(matrix[i][right]);
            }
            if (left < right && up < down) {
                // 右到左
                for (int j = right - 1; j > left; j--) {
                    resList.add(matrix[down][j]);
                }
                // 下到上
                for (int i = down; i > up; i--) {
                    resList.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return resList;
    }
}
/*
54. 螺旋矩阵
https://leetcode.cn/problems/spiral-matrix/

给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

模拟
相似题目: 59. 螺旋矩阵 II
https://leetcode.cn/problems/spiral-matrix-ii/
 */
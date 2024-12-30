import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int[] rowMin = new int[M];
        int[] colMax = new int[N];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
/*
1380. 矩阵中的幸运数
https://leetcode.cn/problems/lucky-numbers-in-a-matrix/

给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
幸运数是指矩阵中满足同时下列两个条件的元素：
- 在同一行的所有元素中最小
- 在同一列的所有元素中最大
提示：
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5
矩阵中的所有元素都是不同的

模拟。
 */
public class Solution3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] colMax = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    ans[i][j] = colMax[j];
                } else {
                    ans[i][j] = matrix[i][j];
                }
            }
        }
        return ans;
    }
}
/*
3033. 修改矩阵
https://leetcode.cn/problems/modify-the-matrix/description/

第 384 场周赛 T1。

给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
返回矩阵 answer 。
提示：
m == matrix.length
n == matrix[i].length
2 <= m, n <= 50
-1 <= matrix[i][j] <= 100
测试用例中生成的输入满足每列至少包含一个非负整数。
 */
import java.util.Arrays;

public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        // n x n 的 方形 整数数组
        int n = matrix.length;

        // f[i][j] 表示到 matrix[i][j] 的下降路径最小和
        int[][] f = new int[n][n];
        // 初始状态
        // dp[][] 首行等于 matrix[][] 首行
        System.arraycopy(matrix[0], 0, f[0], 0, n);
        // 状态转移
        for (int i = 1; i < n; i++) {
            int[] pre = f[i - 1];
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    f[i][j] = Math.min(pre[j], pre[j + 1]);
                } else if (j < n - 1) {
                    f[i][j] = Math.min(pre[j - 1], Math.min(pre[j], pre[j + 1]));
                } else {
                    f[i][j] = Math.min(pre[j - 1], pre[j]);
                }
                f[i][j] += matrix[i][j];
            }
        }
        return Arrays.stream(f[n - 1]).min().orElseThrow();
    }
}
/*
931. 下降路径最小和
https://leetcode.cn/problems/minimum-falling-path-sum/

第 108 场周赛 T3。

给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
提示：
n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

动态规划。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
相似题目: 1289. 下降路径最小和  II
https://leetcode.cn/problems/minimum-falling-path-sum-ii/
 */
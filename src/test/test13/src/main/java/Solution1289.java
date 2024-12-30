import java.util.Arrays;

public class Solution1289 {
    // 时间复杂度 O(n^3)
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        // f[i][j] 表示到 matrix[i][j] 的下降路径最小和
        int[][] f = new int[n][n];
        // 初始状态
        // dp[][] 首行等于 matrix[][] 首行
        System.arraycopy(grid[0], 0, f[0], 0, n);
        // 状态转移
        for (int i = 1; i < n; i++) {
            int[] pre = f[i - 1];
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(min, pre[k]);
                }
                f[i][j] += min + grid[i][j];
            }
        }
        return Arrays.stream(f[n - 1]).min().orElseThrow();
    }

    // 时间复杂度 O(n^2)
    public int minFallingPathSum2(int[][] grid) {
        int n = grid.length;

        // f[i][j] 表示到 matrix[i][j] 的下降路径最小和
        int[][] f = new int[n][n];
        // 初始状态
        // dp[][] 首行等于 matrix[][] 首行
        System.arraycopy(grid[0], 0, f[0], 0, n);
        // 状态转移
        for (int i = 1; i < n; i++) {
            int[] pre = f[i - 1];
            // 预处理 求出 最小值和次小值
            int minimum = Integer.MAX_VALUE;
            int subminor = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (minimum > pre[j]) {
                    subminor = minimum;
                    minimum = pre[j];
                } else if (subminor > pre[j]) {
                    subminor = pre[j];
                }
            }

            for (int j = 0; j < n; j++) {
                if (pre[j] == minimum) {
                    f[i][j] = subminor + grid[i][j];
                } else {
                    f[i][j] = minimum + grid[i][j];
                }
            }
        }
        return Arrays.stream(f[n - 1]).min().orElseThrow();
    }
}
/*
1289. 下降路径最小和  II
https://leetcode.cn/problems/minimum-falling-path-sum-ii/

给你一个 n x n 整数矩阵 arr ，请你返回 非零偏移下降路径 数字和的最小值。
非零偏移下降路径 定义为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
提示：
n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99

动态规划
相似题目: 931. 下降路径最小和
https://leetcode.cn/problems/minimum-falling-path-sum/
 */

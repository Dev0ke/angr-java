public class Solution2428 {
    public int maxSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int max = 0;
        for (int i = 1; i < M - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                int sum = grid[i][j]
                        + grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1]
                        + grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
/*
2428. 沙漏的最大总和
https://leetcode.cn/problems/maximum-sum-of-an-hourglass/

第 313 场周赛 T2。

给你一个大小为 m x n 的整数矩阵 grid 。
按以下形式将矩阵的一部分定义为一个 沙漏 ：
返回沙漏中元素的 最大 总和。
注意：沙漏无法旋转且必须整个包含在矩阵中。
提示：
m == grid.length
n == grid[i].length
3 <= m, n <= 150
0 <= grid[i][j] <= 10^6

模拟。
时间复杂度 O(mn)
 */
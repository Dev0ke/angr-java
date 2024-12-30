import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Set<Integer> mineSet = new HashSet<>();
        for (int[] mine : mines) {
            mineSet.add(mine[0] * n + mine[1]);
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt = mineSet.contains(i * n + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
            cnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                cnt = mineSet.contains(i * n + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
        }

        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt = mineSet.contains(i * n + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
            cnt = 0;
            for (int i = n - 1; i >= 0; i--) {
                cnt = mineSet.contains(i * n + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
/*
764. 最大加号标志
https://leetcode.cn/problems/largest-plus-sign/

在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。
注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
提示：
1 <= n <= 500
1 <= mines.length <= 5000
0 <= xi, yi < n
每一对 (xi, yi) 都 不重复

动态规划，四个方向取最小值。
时间复杂度 O(n^2)
 */
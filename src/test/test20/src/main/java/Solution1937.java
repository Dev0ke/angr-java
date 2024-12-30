import java.util.Arrays;

public class Solution1937 {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] f = new long[n];
        for (int i = 0; i < m; i++) {
            long[] g = new long[n];

            // 左往右
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, f[j] + j);
                g[j] = Math.max(g[j], max + points[i][j] - j);
            }

            // 右往左
            max = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, f[j] - j);
                g[j] = Math.max(g[j], max + points[i][j] + j);
            }

            f = g;
        }
        return Arrays.stream(f).max().orElseThrow();
    }
}
/*
1937. 扣分后的最大得分
https://leetcode.cn/problems/maximum-number-of-points-with-cost/

第 250 场周赛 T3。

给你一个 m x n 的整数矩阵 points （下标从 0 开始）。一开始你的得分为 0 ，你想最大化从矩阵中得到的分数。
你的得分方式为：每一行 中选取一个格子，选中坐标为 (r, c) 的格子会给你的总得分 增加 points[r][c] 。
然而，相邻行之间被选中的格子如果隔得太远，你会失去一些得分。对于相邻行 r 和 r + 1 （其中 0 <= r < m - 1），选中坐标为 (r, c1) 和 (r + 1, c2) 的格子，你的总得分 减少 abs(c1 - c2) 。
请你返回你能得到的 最大 得分。
abs(x) 定义为：
- 如果 x >= 0 ，那么值为 x 。
- 如果 x < 0 ，那么值为 -x 。
提示：
m == points.length
n == points[r].length
1 <= m, n <= 10^5
1 <= m * n <= 10^5
0 <= points[r][c] <= 10^5

动态规划
 */
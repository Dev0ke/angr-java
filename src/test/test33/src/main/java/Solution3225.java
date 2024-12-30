import java.util.Arrays;

public class Solution3225 {
    private int n;
    private long[][] col_sum;
    private long[][][] memo;

    public long maximumScore(int[][] grid) {
        n = grid.length;
        col_sum = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                col_sum[j][i + 1] = col_sum[j][i] + grid[i][j];
            }
        }

        memo = new long[n + 1][n + 1][2];
        for (int a = 0; a < n + 1; a++) {
            for (int b = 0; b < n + 1; b++) {
                Arrays.fill(memo[a][b], -1);
            }
        }
        long ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans = Math.max(ans, dfs(n - 2, i, 0));
        }
        return ans;
    }

    private long dfs(int j, int pre, int dec) {
        if (j < 0) return 0;
        if (memo[j][pre][dec] != -1) return memo[j][pre][dec];
        long res = 0;
        for (int cur = 0; cur < n + 1; cur++) {
            if (pre == cur) { // 相等
                res = Math.max(res, dfs(j - 1, cur, 0));
            } else if (pre > cur) { // 递减
                res = Math.max(res, dfs(j - 1, cur, 1) + col_sum[j][pre] - col_sum[j][cur]);
            } else if (dec == 1) { // 凹形，第 j+2 列一定全是黑色
                if (pre == 1) continue; // 前一列全白最优
                res = Math.max(res, dfs(j - 1, cur, 0));
            } else { // 递增
                res = Math.max(res, dfs(j - 1, cur, 0) + col_sum[j + 1][cur] - col_sum[j + 1][pre]);
            }
        }
        return memo[j][pre][dec] = res;
    }
}
/*
3225. 网格图操作后的最大分数
https://leetcode.cn/problems/maximum-score-from-grid-operations/description/

第 135 场双周赛 T4。

给你一个大小为 n x n 的二维矩阵 grid ，一开始所有格子都是白色的。一次操作中，你可以选择任意下标为 (i, j) 的格子，并将第 j 列中从最上面到第 i 行所有格子改成黑色。
如果格子 (i, j) 为白色，且左边或者右边的格子至少一个格子为黑色，那么我们将 grid[i][j] 加到最后网格图的总分中去。
请你返回执行任意次操作以后，最终网格图的 最大 总分数。
提示：
1 <= n == grid.length <= 100
n == grid[i].length
0 <= grid[i][j] <= 10^9

DP + 优化
结论（从贪心的角度上说，有一种情况 凹形 是不可能的）
---
优化前，需要知道 4 个信息：
当前在第 j 列（传参）
第 j 列的高度（传参）
第 j+1 列的高度（传参）
第 j-1 列的高度（枚举）
O(n^4)
---
优化后，需要 3 个大信息 + 一个 bool 值：
当前在第 j 列（传参）
第 j 列的高度（枚举）
第 j+1 列的高度（传参）
x 第 j-1 列的高度（不枚举）
---
目标：不重不漏地计算答案
时间复杂度 O(n^3)。
灵神直播说这题 rating 分可能达到 3100 分。3100 分是什么概念？详见 1719 题零神评论。。
rating 3011 (clist.by)
 */
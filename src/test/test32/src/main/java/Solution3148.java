import java.util.List;

public class Solution3148 {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int ans = Integer.MIN_VALUE;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid.get(i).get(j);

                int mn = Integer.MAX_VALUE;
                if (i - 1 >= 0) mn = Math.min(mn, f[i - 1][j]);
                if (j - 1 >= 0) mn = Math.min(mn, f[i][j - 1]);
                ans = Math.max(ans, v - mn);
                f[i][j] = Math.min(v, mn);
            }
        }
        return ans;
    }
}
/*
3148. 矩阵中的最大得分
https://leetcode.cn/problems/maximum-difference-score-in-a-grid/description/

第 397 场周赛 T3。

给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。从值为 c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。
你可以从 任一 单元格开始，并且必须至少移动一次。
返回你能得到的 最大 总得分。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 10^5
1 <= grid[i][j] <= 10^5

类动态规划，从左上侧转移到当前位置。
时间复杂度 O(mn)。
 */
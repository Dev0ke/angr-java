import java.util.Arrays;

public class SolutionP2174 {
    private int m, n;
    private int[] memo;

    public int removeOnes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sum += 1 << (i * n + j);
                }
            }
        }
        memo = new int[sum + 1];
        Arrays.fill(memo, -1);
        return dfs(sum);
    }

    private int dfs(int mask) {
        if (mask == 0) return 0;
        if (memo[mask] != -1) return memo[mask];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m * n; i++) {
            if ((mask >> i & 1) == 1) {
                int row = i / n;
                int col = i % n;
                int nxt_state = mask;
                for (int r = 0; r < m; r++) {
                    int b = 1 << (r * n + col) & nxt_state;
                    if (b != 0) nxt_state ^= b;
                }
                for (int c = 0; c < n; c++) {
                    int b = 1 << (row * n + c) & nxt_state;
                    if (b != 0) nxt_state ^= b;
                }
                ans = Math.min(ans, dfs(nxt_state));
            }
        }
        return memo[mask] = ans + 1;
    }
}
/*
$2174. 通过翻转行或列来去除所有的 1 II
https://leetcode.cn/problems/remove-all-ones-with-row-and-column-flips-ii/description/

给定 下标从 0 开始 的 m x n 二进制 矩阵 grid。
在一次操作中，可以选择满足以下条件的任意 i 和 j:
- 0 <= i < m
- 0 <= j < n
- grid[i][j] == 1
并将第 i 行和第 j 列中的 所有 单元格的值更改为零。
返回从 grid 中删除所有 1 所需的最小操作数。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 15
1 <= m * n <= 15
grid[i][j] 为 0 或 1。

相似题目: $2128. 通过翻转行或列来去除所有的 1
https://leetcode.cn/problems/remove-all-ones-with-row-and-column-flips/description/
时间复杂度 O(mn * 2^mn)。
 */
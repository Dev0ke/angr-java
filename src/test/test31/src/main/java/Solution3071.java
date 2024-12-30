import java.util.ArrayList;
import java.util.List;

public class Solution3071 {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;

        // 0,0 1,1
        // 0,4 1,4
        List<Integer> y = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            y.add(grid[i][i]);
            y.add(grid[i][n - 1 - i]);
            vis[i][i] = true;
            vis[i][n - 1 - i] = true;
        }
        for (int i = m; i < n; i++) {
            y.add(grid[i][m]);
            vis[i][m] = true;
        }

        List<Integer> not_y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    not_y.add(grid[i][j]);
                }
            }
        }

        // 0,1,2
        int[] y_ans = new int[3];
        int[] not_y_ans = new int[3];
        for (int i = 0; i < 3; i++) {
            y_ans[i] = getAns(y, i);
            not_y_ans[i] = getAns(not_y, i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                ans = Math.min(ans, y_ans[i] + not_y_ans[j]);
            }
        }
        return ans;
    }

    private int getAns(List<Integer> a, int k) {
        int res = 0;
        for (Integer v : a) {
            res += v != k ? 1 : 0;
        }
        return res;
    }
}
/*
3071. 在矩阵上写出字母 Y 所需的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-write-the-letter-y-on-a-grid/description/

第 387 场周赛 T3。

给你一个下标从 0 开始、大小为 n x n 的矩阵 grid ，其中 n 为奇数，且 grid[r][c] 的值为 0 、1 或 2 。
如果一个单元格属于以下三条线中的任一一条，我们就认为它是字母 Y 的一部分：
- 从左上角单元格开始到矩阵中心单元格结束的对角线。
- 从右上角单元格开始到矩阵中心单元格结束的对角线。
- 从中心单元格开始到矩阵底部边界结束的垂直线。
当且仅当满足以下全部条件时，可以判定矩阵上写有字母 Y ：
- 属于 Y 的所有单元格的值相等。
- 不属于 Y 的所有单元格的值相等。
- 属于 Y 的单元格的值与不属于Y的单元格的值不同。
每次操作你可以将任意单元格的值改变为 0 、1 或 2 。返回在矩阵上写出字母 Y 所需的 最少 操作次数。
提示：
3 <= n <= 49
n == grid.length == grid[i].length
0 <= grid[i][j] <= 2
n 为奇数。

暴力模拟。
时间复杂度 O(n^2 * 3*3)
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionP2371 {
    public int[][] minScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 将所有数字排序
        List<int[]> nums = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                nums.add(new int[]{grid[r][c], r, c});
            }
        }
        nums.sort(Comparator.comparingInt(o -> o[0]));

        // 从最小的数字开始填入，每次更新当前行和列的最大值
        int[] row_max = new int[m];
        int[] col_max = new int[n];
        int[][] ans = new int[m][n];
        for (int[] p : nums) {
            int r = p[1], c = p[2];
            ans[r][c] = Math.max(row_max[r], col_max[c]) + 1;
            row_max[r] = ans[r][c];
            col_max[c] = ans[r][c];
        }
        return ans;
    }
}
/*
$2371. 最小化网格中的最大值
https://leetcode.cn/problems/minimize-maximum-value-in-a-grid/description/

给定一个包含 不同 正整数的 m × n 整数矩阵 grid。
必须将矩阵中的每一个整数替换为正整数，且满足以下条件:
- 在替换之后，同行或同列中的每两个元素的 相对 顺序应该保持 不变。
- 替换后矩阵中的 最大 数目应尽可能 小。
如果对于原始矩阵中的所有元素对，使 grid[r1][c1] > grid[r2][c2]，其中要么 r1 == r2 ，要么 c1 == c2，则相对顺序保持不变。那么在替换之后一定满足 grid[r1][c1] > grid[r2][c2]。
例如，如果 grid = [[2, 4, 5], [7, 3, 9]]，那么一个好的替换可以是 grid = [[1, 2, 3], [2, 1, 4]] 或 grid = [[1, 2, 3], [3, 1, 4]]。
返回 结果 矩阵。如果有多个答案，则返回其中 任何 一个。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
1 <= grid[i][j] <= 10^9
grid 由不同的整数组成。

比 1632 简单的点在于，本题 grid 是不同的 正整数。
本题用 1632 的代码提交，也可以 AC。
相似题目: 1632. 矩阵转换后的秩
https://leetcode.cn/problems/rank-transform-of-a-matrix/description/
 */
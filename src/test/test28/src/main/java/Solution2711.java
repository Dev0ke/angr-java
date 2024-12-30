import java.util.HashSet;
import java.util.Set;

public class Solution2711 {
    private int[][] grid;
    private int m, n;

    public int[][] differenceOfDistinctValues(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Math.abs(topLeft(i, j) - bottomRight(i, j));
            }
        }
        return ans;
    }

    private int topLeft(int x, int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            set.add(grid[i][j]);
        }
        return set.size();
    }

    private int bottomRight(int x, int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = x + 1, j = y + 1; i < m && j < n; i++, j++) {
            set.add(grid[i][j]);
        }
        return set.size();
    }
}
/*
2711. 对角线上不同值的数量差
https://leetcode.cn/problems/difference-of-number-of-distinct-values-on-diagonals/

第 347 场周赛 T2。

给你一个下标从 0 开始、大小为 m x n 的二维矩阵 grid ，请你求解大小同样为 m x n 的答案矩阵 answer 。
矩阵 answer 中每个单元格 (r, c) 的值可以按下述方式进行计算：
- 令 topLeft[r][c] 为矩阵 grid 中单元格 (r, c) 左上角对角线上 不同值 的数量。
- 令 bottomRight[r][c] 为矩阵 grid 中单元格 (r, c) 右下角对角线上 不同值 的数量。
然后 answer[r][c] = |topLeft[r][c] - bottomRight[r][c]| 。
返回矩阵 answer 。
矩阵对角线 是从最顶行或最左列的某个单元格开始，向右下方向走到矩阵末尾的对角线。
如果单元格 (r1, c1) 和单元格 (r, c) 属于同一条对角线且 r1 < r ，则单元格 (r1, c1) 属于单元格 (r, c) 的左上对角线。类似地，可以定义右下对角线。
提示：
m == grid.length
n == grid[i].length
1 <= m, n, grid[i][j] <= 50

模拟。
时间复杂度 O(mn * min(m,n))
也可以使用前后缀分解的方式优化（对角线）
 */
import java.util.ArrayList;
import java.util.List;

public class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = m * n;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int cur_id = i * n + j;
                int pre_id = ((cur_id - k) % mn + mn) % mn;
                int x = pre_id / n, y = pre_id % n;
                row.add(grid[x][y]);
            }
            ans.add(row);
        }
        return ans;
    }
}
/*
1260. 二维网格迁移
https://leetcode.cn/problems/shift-2d-grid/description/

给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
每次「迁移」操作将会引发下述活动：
- 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
- 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
- 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。
提示：
m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100

二维转为一维，相当于一维数组的循环左移。
时间复杂度 O(mn)。
 */
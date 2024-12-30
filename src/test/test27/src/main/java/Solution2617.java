import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class Solution2617 {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // y->[x]
        List<TreeSet<Integer>> unVisitedXs = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            TreeSet<Integer> unVisitedX = new TreeSet<>();
            for (int i = 0; i < m; i++) unVisitedX.add(i);
            unVisitedXs.add(unVisitedX);
        }
        // x->[y]
        List<TreeSet<Integer>> unVisitedYs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            TreeSet<Integer> unVisitedY = new TreeSet<>();
            for (int j = 0; j < n; j++) unVisitedY.add(j);
            unVisitedYs.add(unVisitedY);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1], cstep = tuple[2];
                if (cx == m - 1 && cy == n - 1) {
                    return cstep;
                }

                int yDown = cy + 1;
                int yUp = Math.min(grid[cx][cy] + cy, n - 1);
                TreeSet<Integer> unVisY = unVisitedYs.get(cx);
                for (Integer ny = unVisY.ceiling(yDown); ny != null && ny <= yUp; ny = unVisY.higher(ny)) {
                    queue.add(new int[]{cx, ny, cstep + 1});
                    unVisY.remove(ny);
                }

                int xDown = cx + 1;
                int xUp = Math.min(grid[cx][cy] + cx, m - 1);
                TreeSet<Integer> unVisX = unVisitedXs.get(cy);
                for (Integer nx = unVisX.ceiling(xDown); nx != null && nx <= xUp; nx = unVisX.higher(nx)) {
                    queue.add(new int[]{nx, cy, cstep + 1});
                    unVisX.remove(nx);
                }
            }
        }
        return -1;
    }
}
/*
2617. 网格图中最少访问的格子数
https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/

第 340 场周赛 T4。

给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。
当你在格子 (i, j) 的时候，你可以移动到以下格子之一：
- 满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者
- 满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。
请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10^5
1 <= m * n <= 10^5
0 <= grid[i][j] < m * n
grid[m - 1][n - 1] == 0

BFS + 平衡树剪枝
上周周赛 T4 的二维版本。
时间复杂度 O(mnlog(mn))
相似题目: 2612. 最少翻转操作数
https://leetcode.cn/problems/minimum-reverse-operations/
 */
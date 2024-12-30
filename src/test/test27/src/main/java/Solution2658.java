import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2658 {
    public static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private int m, n;

    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int area = getArea(visited, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int getArea(boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int area = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1];
                area += grid[cx][cy];

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n
                            && grid[nx][ny] > 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return area;
    }
}
/*
2658. 网格图中鱼的最大数目
https://leetcode.cn/problems/maximum-number-of-fish-in-a-grid/

第 103 场双周赛 T3。

给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，其中下标在 (r, c) 处的整数表示：
- 如果 grid[r][c] = 0 ，那么它是一块 陆地 。
- 如果 grid[r][c] > 0 ，那么它是一块 水域 ，且包含 grid[r][c] 条鱼。
一位渔夫可以从任意 水域 格子 (r, c) 出发，然后执行以下操作任意次：
- 捕捞格子 (r, c) 处所有的鱼，或者
- 移动到相邻的 水域 格子。
请你返回渔夫最优策略下， 最多 可以捕捞多少条鱼。如果没有水域格子，请你返回 0 。
格子 (r, c) 相邻 的格子为 (r, c + 1) ，(r, c - 1) ，(r + 1, c) 和 (r - 1, c) ，前提是相邻格子在网格图内。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10
0 <= grid[i][j] <= 10

BFS。
时间复杂度 O(mn)
相似题目: 695. 岛屿的最大面积
https://leetcode.cn/problems/max-area-of-island/
 */
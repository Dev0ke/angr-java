import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // 新鲜橘子数量
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }

        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && grid[nextM][nextN] == 1) {
                        grid[nextM][nextN] = 2;
                        fresh--;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return (fresh == 0) ? time : -1;
    }
}
/*
994. 腐烂的橘子
https://leetcode.cn/problems/rotting-oranges/

在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
- 值 0 代表空单元格；
- 值 1 代表新鲜橘子；
- 值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] 仅为 0、1 或 2

BFS，退出条件为队列中没有新增 腐烂的橘子。
 */
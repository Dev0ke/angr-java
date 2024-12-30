import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2596 {
    private static final int[][] DIRECTIONS = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int cx = cur[0];
            int cy = cur[1];
            for (int[] dir : DIRECTIONS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && !vis[nx][ny] && grid[nx][ny] == grid[cx][cy] + 1) {
                    vis[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
            if (queue.size() > 1) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
2596. 检查骑士巡视方案
https://leetcode.cn/problems/check-knight-tour-configuration/

第 337 场周赛 T2。

骑士在一张 n x n 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
提示：
n == grid.length == grid[i].length
3 <= n <= 7
0 <= grid[row][col] < n * n
grid 中的所有整数 互不相同

模拟。
相似题目: $1197. 进击的骑士
https://leetcode.cn/problems/minimum-knight-moves/
 */
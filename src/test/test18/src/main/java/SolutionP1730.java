import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionP1730 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    q.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            ans++;
            for (int i = 0; i < sz; i++) {
                int[] top = q.remove();
                int cx = top[0], cy = top[1];
                if (grid[cx][cy] == '*') return ans;

                for (int[] d : DIRECTIONS) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 'X') {
                        if (grid[nx][ny] == '*') return ans;
                        grid[nx][ny] = 'X';
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
/*
$1730. 获取食物的最短路径
https://leetcode.cn/problems/shortest-path-to-get-food/description/

你现在很饿，想要尽快找东西吃。你需要找到最短的路径到达一个食物所在的格子。
给定一个 m x n 的字符矩阵 grid ，包含下列不同类型的格子：
- '*' 是你的位置。矩阵中有且只有一个 '*' 格子。
- '#' 是食物。矩阵中可能存在多个食物。
- 'O' 是空地，你可以穿过这些格子。
- 'X' 是障碍，你不可以穿过这些格子。
返回你到任意食物的最短路径的长度。如果不存在你到任意食物的路径，返回 -1。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[row][col] 是 '*'、 'X'、 'O' 或 '#' 。
grid 中有且只有一个 '*' 。

多源 BFS。
时间复杂度 O(mn)。
 */
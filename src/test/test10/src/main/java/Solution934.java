import java.util.LinkedList;
import java.util.Queue;

public class Solution934 {
    private int M;
    private int N;

    public int shortestBridge(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;

        // 将其中一个岛 标记成 2
        this.change1To2(grid);

        // BFS
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (grid[cur[0]][cur[1]] == 1) {
                    return step;
                }

                for (int[] dir : directions) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !visited[nextM][nextN]) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
            step++;
        }
        return step;
    }

    private void change1To2(int[][] grid) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return;
                }
            }
        }
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i >= 0 && i < M && j >= 0 && j < N && grid[i][j] == 1) {
            grid[i][j] = 2;
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }
}
/*
934. 最短的桥
https://leetcode.cn/problems/shortest-bridge/

在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。）
提示：
2 <= A.length == A[0].length <= 100
A[i][j] == 0 或 A[i][j] == 1

注意是两座岛，不是更多。这是比较简单的：可以将其中一座标记出来，求最近距离，多源 BFS。
时间复杂度 O(mn + mn) 即 O(mn)
 */
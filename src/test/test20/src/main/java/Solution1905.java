import java.util.LinkedList;
import java.util.Queue;

public class Solution1905 {
    private int M;
    private int N;
    private boolean[][] visited;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.M = grid1.length;
        this.N = grid1[0].length;
        this.visited = new boolean[M][N];

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid2[i][j] == 1 && grid1[i][j] == 1) {
                    visited[i][j] = true;
                    cnt += bfs(grid1, grid2, i, j);
                }
            }
        }
        return cnt;
    }

    private int bfs(int[][] grid1, int[][] grid2, int curI, int curJ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curI, curJ});
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();

                for (int[] dir : directions) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N
                            && !visited[nextM][nextN] && grid2[nextM][nextN] == 1) {
                        if (grid1[nextM][nextN] != 1) {
                            // 不能直接 return 0，要处理完余下的岛屿
                            res = 0;
                        }
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return res;
    }
}
/*
1905. 统计子岛屿
https://leetcode.cn/problems/count-sub-islands/

给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。
一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
请你返回 grid2 中 子岛屿 的 数目 。
提示：
m == grid1.length == grid2.length
n == grid1[i].length == grid2[i].length
1 <= m, n <= 500
grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。

BFS 模拟。在 grid2 中搜索某一个岛屿的过程中，我们需要判断岛屿包含的每一个格子是否都在 grid1 中出现了。如果全部出现，那么将答案增加 11。
时间复杂度 O(mn)
空间复杂度 O(mn)
相似题目: 200. 岛屿数量
https://leetcode.cn/problems/number-of-islands/
 */
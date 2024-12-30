import java.util.LinkedList;
import java.util.Queue;

public class Solution1293 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        int M = grid.length;
        int N = grid[0].length;

        // FIX [[0]]
        if (M == 1 && N == 1) {
            return 0;
        }
        int step = 0;
        // int[0..1..2]
        Queue<int[]> queue = new LinkedList<>();
        // 起点
        queue.add(new int[]{0, 0, 0});
        // 二维标记位置 三维标记到此节点的路径处理障碍总个数
        int[][][] visited = new int[M][N][k + 1];
        visited[0][0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();

                // 同一个节点被访问的时候 已经使用消除障碍物的次数
                int curCnt = cur[2];
                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM < 0 || nextN < 0 || nextM >= M || nextN >= N) {
                        continue;
                    }
                    if (nextM == M - 1 && nextN == N - 1) {
                        return step + 1;
                    }
                    // 穿越障碍次数已满
                    if (grid[nextM][nextN] == 1 && curCnt >= k) {
                        continue;
                    }
                    int nextCnt = grid[nextM][nextN] == 1 ? curCnt + 1 : curCnt;
                    if (visited[nextM][nextN][nextCnt] == 0) {
                        queue.add(new int[]{nextM, nextN, nextCnt});
                        visited[nextM][nextN][nextCnt] = 1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
/*
1293. 网格中的最短路径
https://leetcode.cn/problems/shortest-path-in-a-grid-with-obstacles-elimination/

第 167 场周赛 T4。

给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
提示：
grid.length == m
grid[0].length == n
1 <= m, n <= 40
1 <= k <= m*n
grid[i][j] 是 0 或 1
grid[0][0] == grid[m-1][n-1] == 0

BFS
 */
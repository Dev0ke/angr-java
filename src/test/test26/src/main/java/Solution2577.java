import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2577 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minimumTime(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // “困毙”
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[M][N];
        // 到达 grid[i][j] 所需的最少时间
        int[][] t = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(t[i], Integer.MAX_VALUE);
        }
        t[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int cx = tuple[0], cy = tuple[1], ct = tuple[2];
            if (visited[cx][cy]) {
                continue;
            }
            visited[cx][cy] = true;

            for (int[] dir : DIRECTIONS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    // “走闲”
                    int nt = ct + 1 + (Math.max(0, grid[nx][ny] - ct) / 2 * 2);
                    if (t[nx][ny] > nt) {
                        t[nx][ny] = nt;
                        queue.add(new int[]{nx, ny, nt});
                    }
                }
            }
        }
        return t[M - 1][N - 1];
    }
}
/*
2577. 在网格图中访问一个格子的最少时间
https://leetcode.cn/problems/minimum-time-to-visit-a-cell-in-a-grid/

第 334 场周赛 T4。

给你一个 m x n 的矩阵 grid ，每个元素都为 非负 整数，其中 grid[row][col] 表示可以访问格子 (row, col) 的 最早 时间。
也就是说当你访问格子 (row, col) 时，最少已经经过的时间为 grid[row][col] 。
你从 最左上角 出发，出发时刻为 0 ，你必须一直移动到上下左右相邻四个格子中的 任意 一个格子（即不能停留在格子上）。每次移动都需要花费 1 单位时间。
请你返回 最早 到达右下角格子的时间，如果你无法到达右下角的格子，请你返回 -1 。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 10^5
0 <= grid[i][j] <= 10^5
grid[0][0] == 0

堆优化 Dijkstra 最短路。
首先，特判 `grid[0][1] > 1 && grid[1][0] > 1` 情况，此时“困毙”（“困毙”：中国象棋术语。指轮到行棋的一方，棋子没有被将军，但所有棋子被困在原地无子可动，即被困毙）。
否则，可以通过“走闲”来凑时间，总能到达终点（“走闲”：中国象棋术语。表示行棋方无意进攻，走闲是用于等待时机或用于防守的战术）。
注意时间奇偶性：因“走闲”一次时间 +2。如：3->5 需要 t+2+1；3->6 同样需要 t+2+1。
最后 dijkstra 求最短路即可。
时间复杂度 O(mnlogmn)
本题还有二分 + BFS 解法。
相似题目: 778. 水位上升的泳池中游泳
https://leetcode.cn/problems/swim-in-rising-water/
 */
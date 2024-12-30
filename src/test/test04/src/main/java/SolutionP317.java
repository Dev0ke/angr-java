import java.util.LinkedList;
import java.util.Queue;

public class SolutionP317 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;

    public int shortestDistance(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        int[][] totalDist = new int[M][N];

        // 空地标记 状态每轮复用，要能到达所有的建筑
        int emptyLand = 0;

        int res = -1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 每一个 1 代表一个你不能通过的 建筑
                if (grid[i][j] == 1) {
                    // 多源 BFS
                    res = bfs(grid, i, j, totalDist, emptyLand);
                    if (res == -1) {
                        return -1;
                    }
                    emptyLand--;
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int m, int n, int[][] totalDist, int emptyLand) {
        // [m,n,dist]
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{m, n, 0});

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();

            for (int[] dir : DIRECTIONS) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && grid[nextM][nextN] == emptyLand) {
                    // 下一轮的空地
                    grid[nextM][nextN]--;

                    int dist = cur[2] + 1;
                    totalDist[nextM][nextN] += dist;
                    min = Math.min(min, totalDist[nextM][nextN]);

                    queue.add(new int[]{nextM, nextN, dist});
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
/*
$317. 离建筑物最近的距离
https://leetcode.cn/problems/shortest-distance-from-all-buildings/

给你一个 m × n 的网格，值为 0 、 1 或 2 ，其中:
- 每一个 0 代表一块你可以自由通过的 空地
- 每一个 1 代表一个你不能通过的 建筑
- 每个 2 标记一个你不能通过的 障碍
你想要在一块空地上建造一所房子，在 最短的总旅行距离 内到达所有的建筑。你只能上下左右移动。
返回到该房子的 最短旅行距离 。如果根据上述规则无法建造这样的房子，则返回 -1 。
总旅行距离 是朋友们家到聚会地点的距离之和。
使用 曼哈顿距离 计算距离，其中距离 (p1, p2) = |p2.x - p1.x | + | p2.y - p1.y | 。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] 是 0, 1 或 2
grid 中 至少 有 一幢 建筑

多源 BFS
因为要找到一块空地能够到达所有的建筑，所以要求取交集，设有 n 个建筑，需要进行 n 轮 BFS。并且结果集范围在不断减少。
 */
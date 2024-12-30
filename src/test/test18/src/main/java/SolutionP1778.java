import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SolutionP1778 {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 对应UDLR
    private static final char[] FORWARD = {'U', 'D', 'L', 'R'};
    private static final char[] BACKWARD = {'D', 'U', 'R', 'L'};
    private static final int UNKNOWN = -2, BLOCKED = 0, EMPTY = 1, TARGET = 2;
    private static final int MAX_N = 1005;
    private GridMaster master;
    private int[][] grid;
    private boolean canVisitTarget;

    public int findShortestPath(GridMaster master) {
        this.master = master;
        grid = new int[MAX_N][MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            Arrays.fill(grid[i], UNKNOWN);
        }
        canVisitTarget = false;

        int sx = 501, sy = 501;
        // dfs 寻找target，顺便建图
        dfs(sx, sy);

        // 优化: dfs 没有找到 target 的话直接返回-1
        if (!canVisitTarget) return -1;

        // bfs 遍历图，计算最短路径
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        grid[sx][sy] = BLOCKED;
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int s = 0; s < size; s++) {
                int[] top = q.remove();

                for (int i = 0; i < 4; i++) {
                    int x = top[0] + DIRS[i][0];
                    int y = top[1] + DIRS[i][1];
                    if (grid[x][y] == TARGET) return dist;
                    if (grid[x][y] == BLOCKED) continue;
                    grid[x][y] = BLOCKED;
                    q.add(new int[]{x, y});
                }
            }
        }
        return -1;
    }

    private void dfs(int i, int j) {
        if (grid[i][j] != UNKNOWN) return;
        if (master.isTarget()) {
            grid[i][j] = TARGET;
            canVisitTarget = true;
        } else {
            grid[i][j] = EMPTY;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + DIRS[k][0];
            int y = j + DIRS[k][1];
            char forward = FORWARD[k];
            char backward = BACKWARD[k];

            if (master.canMove(forward)) {
                master.move(forward);
                dfs(x, y);
                master.move(backward);
            } else {
                grid[x][y] = BLOCKED;
            }
        }
    }

    // UT
    interface GridMaster {
        boolean canMove(char direction);

        void move(char direction);

        boolean isTarget();
    }
}
/*
$1778. 未知网格中的最短路径
https://leetcode.cn/problems/shortest-path-in-a-hidden-grid/description/

这是一个交互式的问题。
一个未知的网格里有一个机器人，你需要让机器人从起点走到终点。这个网格的大小是 m x n，网格中的每个位置只会是可通行和不可通行两种状态。题目保证机器人的起点和终点不同，且都是可通行的。
你需要找到起点到终点的最短路径，然而你不知道网格的大小、起点和终点。你只能向 GridMaster 对象查询。
GridMaster有这些方法：
- boolean canMove(char direction) 当机器人能向对应方向移动时，返回 true，否则返回 false。
- void move(char direction) 把机器人向这个方向移动。如果移动方向上是不可通行的或是网格的边界，则这次移动会被忽略，机器人会待在原地。
- boolean isTarget() 如果机器人当前位于终点，返回 true，否则返回 false。
注意上述方法中的direction应该是 {'U','D','L','R'} 中的一个，分别代表上下左右四个方向。
返回机器人的初始位置到终点的最短距离。如果在起点和终点间没有路径联通，返回 -1。
自定义测试用例
测试用例是一个 m x n 的二维矩阵 grid，其中：
- grid[i][j] == -1 表明机器人一开始位于位置 (i, j) （即起点）。
- grid[i][j] == 0 表明位置 (i, j) 不可通行。
- grid[i][j] == 1 表明位置 (i, j) 可以通行.
- grid[i][j] == 2 表明位置 (i, j) 是终点.
grid 里恰有一个-1 和一个 2。记住在你的代码中，你对这些信息将一无所知。
提示：
1 <= n, m <= 500
m == grid.length
n == grid[i].length
grid[i][j] 只可能是 -1, 0, 1 或 2
grid 中 有且只有一个 -1
grid 中 有且只有一个 2

DFS还原 + BFS最短路。
相似题目: $1810. 隐藏网格下的最小消耗路径
https://leetcode.cn/problems/minimum-path-cost-in-a-hidden-grid/description/
 */
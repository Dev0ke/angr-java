import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionP1810 {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 对应UDLR
    private static final char[] FORWARD = {'U', 'D', 'L', 'R'};
    private static final char[] BACKWARD = {'D', 'U', 'R', 'L'};
    private static final int MAX_N = 205;
    private static final int UNKNOWN = -2;
    private GridMaster master;
    private int[][] grid;
    int tx, ty;

    public int findShortestPath(GridMaster master) {
        this.master = master;
        grid = new int[MAX_N][MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            Arrays.fill(grid[i], UNKNOWN);
        }
        int[][] g2 = new int[MAX_N][MAX_N];

        int sx = 101, sy = 101;
        // dfs 寻找target，顺便建图
        dfs(sx, sy);
        grid[sx][sy] = 0;

        int[][] dist = dijkstra_mlogm(sx, sy);
        return dist[tx][ty] == INF ? -1 : dist[tx][ty];
    }

    void dfs(int i, int j) {
        if (grid[i][j] != UNKNOWN) return;
        if (master.isTarget()) {
            tx = i;
            ty = j;
        }
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + DIRS[k][0];
            int y = j + DIRS[k][1];
            char forward = FORWARD[k];
            char backward = BACKWARD[k];

            if (master.canMove(forward)) {
                int wt = master.move(forward);
                dfs(x, y);
                grid[x][y] = wt; // 注意赋值 不能写到 dfs 前面
                master.move(backward);
            } else {
                grid[x][y] = INF;
            }
        }
    }

    private static final int INF = (int) 1e9;

    int[][] dijkstra_mlogm(int sx, int sy) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        boolean[][] vis = new boolean[MAX_N][MAX_N];
        int[][] dist = new int[MAX_N][MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            Arrays.fill(dist[i], INF);
        }
        pq.add(new int[]{sx, sy, 0});
        dist[sx][sy] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int cx = top[0], cy = top[1];

            if (vis[cx][cy]) continue;
            vis[cx][cy] = true;
            for (int[] d : DIRS) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if (nx >= 0 && nx < MAX_N && ny >= 0 && ny < MAX_N) {
                    int wt = grid[nx][ny];
                    if (wt == UNKNOWN) continue;
                    if (dist[nx][ny] > dist[cx][cy] + wt) {
                        dist[nx][ny] = dist[cx][cy] + wt;
                        pq.add(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }
        }
        return dist;
    }

    interface GridMaster {
        boolean canMove(char direction);

        int move(char direction);

        boolean isTarget();
    }
}
/*
$1810. 隐藏网格下的最小消耗路径
https://leetcode.cn/problems/minimum-path-cost-in-a-hidden-grid/description/

这是一个交互问题。
有一个机器人存在于网格中，你需要通过不断尝试使他从初始单元到达目标单元。网格的规格为m x n，并且每个单元的属性值要不为空，要不已被占用。题目保证初始网格和目标网格不同且均为空。
每个单元格都有消耗值，你需要在每次移动至此单元格后支付该费用。在机器人启动前，初始单元的费用不被计算在内。
你需要找到机器人移动至目标网格的最小总消耗。但可惜的是你并不知道网格的尺寸、初始单元和目标单元。你只允许通过询问GridMaster类获得信息。
GridMaster类存在以下功能：
- boolean canMove(char direction) 当机器人可以向这个方向移动时，返回true；反之返回false。
- int move(char direction) 沿该方向移动机器人，并返回移动到该单元的消耗值。如果此移动将机器人移动到被占有的单元格或离开网格，则移动将被忽略，机器人将保持在相同的位置，函数将返回-1。
- boolean isTarget() ：如果机器人当前位于目标单元格上，则返回true；反之返回 false 。
请注意，上述函数中的方向应该是{ 'U'、'D'、'L'、'R' }中的字符，分别表示向上、向下、左和右方向。
返回使机器人从其初始起始单元到目标单元的最小总消耗。如果单元格之间不存在有效路径，则返回-1。
测试实例:
测试输入一个大小为m x n的二维数组 grid 和四个int型参数 r1, c1, r2, 和 c2 :
- grid[i][j] == 0 表示网格 (i, j) 已被占用。
- grid[i][j] >= 1 表示网格单元 (i, j) 为空并且 grid[i][j] 的值为移动至此网格的成本值。
- (r1, c1) 为初始单元。
- (r2, c2) 为目标单元。
请注意，你将无法在你的代码中获知这些信息。
提示:
1 <= n, m <= 100
m == grid.length
n == grid[i].length
0 <= grid[i][j] <= 100

DFS还原 + dijkstra 最短路。
相似题目: $1778. 未知网格中的最短路径
https://leetcode.cn/problems/shortest-path-in-a-hidden-grid/description/
 */
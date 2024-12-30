import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionP2852 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public long sumRemoteness(int[][] grid) {
        int n = grid.length;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    totalSum += grid[i][j];
                }
            }
        }
        long ans = 0;
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0 || vis[i][j]) {
                    continue;
                }
                int count = 0;
                long currSum = 0;
                vis[i][j] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                while (!q.isEmpty()) {
                    int[] top = q.remove();
                    count++;
                    int cx = top[0], cy = top[1];
                    currSum += grid[cx][cy];
                    for (int[] d : DIRECTIONS) {
                        int nx = cx + d[0];
                        int ny = cy + d[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n
                                && grid[nx][ny] > 0 && !vis[nx][ny]) {
                            vis[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                ans += count * (totalSum - currSum);
            }
        }
        return ans;
    }
}
/*
$2852. 所有单元格的远离程度之和
https://leetcode.cn/problems/sum-of-remoteness-of-all-cells/description/

给定一个下标从 0 开始的大小为 n * n 的矩阵 grid，其中每个单元格的值 grid[i][j] 要么是 正整数，要么是表示阻塞单元格的值 -1 。
你可以从一个非阻塞单元格移动到与其共享边的任何非阻塞单元格。
对于任何单元格 (i, j)，我们定义其 远离程度 R[i][j] 如下：
- 如果单元格 (i, j) 是 非阻塞 单元格，则 R[i][j] 是值 grid[x][y] 的总和，其中 没有 从 非阻塞 单元格 (x, y) 到单元格 (i, j) 的路径。
- 对于阻塞单元格，R[i][j] == 0。
返回所有单元格的 R[i][j] 之和。
提示：
1 <= n <= 300
1 <= grid[i][j] <= 10^6 或 grid[i][j] == -1

BFS。
https://leetcode.cn/problems/sum-of-remoteness-of-all-cells/solutions/2811061/2852-suo-you-dan-yuan-ge-de-yuan-chi-che-6f94/
用 totalSum 表示矩阵 grid 中的所有正整数之和。如果存在一个连通分量的单元格个数是 count 且所有单元格的元素之和是 currSum，
则该连通分量中的每个单元格的远离程度都等于 totalSum−currSum，该连通分量中的所有单元格的远离程度之和等于 count×(totalSum−currSum)。
时间复杂度 O(n^2)。
 */
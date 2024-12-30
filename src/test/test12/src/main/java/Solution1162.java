import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1162 {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // BFS
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 如果网格上只有陆地或者海洋，请返回 -1。
        if (queue.size() == 0 || queue.size() == m * n) {
            return -1;
        }

        int max = 1;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                max = Math.max(max, distance);

                for (int[] dir : DIRECTIONS) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            distance++;
        }
        return max;
    }
}
/*
1162. 地图分析
https://leetcode.cn/problems/as-far-from-land-as-possible/

你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。
其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。如果网格上只有陆地或者海洋，请返回 -1。
我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
提示：
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] 不是 0 就是 1

多源 BFS。
时间复杂度 O(n^2)
 */
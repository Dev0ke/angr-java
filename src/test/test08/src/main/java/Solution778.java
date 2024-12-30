import java.util.LinkedList;
import java.util.Queue;

public class Solution778 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int N = grid.length;

        // 二分
        int left = grid[0][0];
        int right = N * N;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[][] grid, int mid) {
        int N = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == N - 1 && cur[1] == N - 1) {
                    return true;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < N && nextN >= 0 && nextN < N
                            && !visited[nextM][nextN] && grid[nextM][nextN] <= mid) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return false;
    }
}
/*
778. 水位上升的泳池中游泳
https://leetcode.cn/problems/swim-in-rising-water/

在一个 n x n 的整数矩阵 grid 中，每一个方格的值 grid[i][j] 表示位置 (i, j) 的平台高度。
当开始下雨时，在时间为 t 时，水池中的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
你从坐标方格的左上平台 (0，0) 出发。返回 你到达坐标方格的右下平台 (n-1, n-1) 所需的最少时间 。
提示:
n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n^2
grid[i][j] 中每个值 均无重复

二分 + BFS
相似题目: 1631. 最小体力消耗路径
https://leetcode.cn/problems/path-with-minimum-effort/
 */
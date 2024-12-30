import java.util.LinkedList;
import java.util.Queue;

public class Solution1631 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        // 二分
        int left = 0;
        int right = 1000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(heights, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[][] heights, int mid) {
        int M = heights.length;
        int N = heights[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == M - 1 && cur[1] == N - 1) {
                    return true;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N
                            && !visited[nextM][nextN]
                            && Math.abs(heights[nextM][nextN] - heights[cur[0]][cur[1]]) <= mid) {
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
1631. 最小体力消耗路径
https://leetcode.cn/problems/path-with-minimum-effort/

你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
请你返回从左上角走到右下角的最小 体力消耗值 。
提示：
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 10^6

二分 + BFS
相似题目: 778. 水位上升的泳池中游泳
https://leetcode.cn/problems/swim-in-rising-water/
1970. 你能穿过矩阵的最后一天
https://leetcode.cn/problems/last-day-where-you-can-still-cross/
 */
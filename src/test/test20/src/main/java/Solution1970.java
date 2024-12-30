import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1970 {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = row * col;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(row, col, cells, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean checkMid(int row, int col, int[][] cells, int mid) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int i = 0; i < mid; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 1) {
                queue.add(new int[]{0, j});
                grid[0][j] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == row - 1) {
                    return true;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < row && nextN >= 0 && nextN < col && grid[nextM][nextN] == 1) {
                        queue.add(new int[]{nextM, nextN});
                        grid[nextM][nextN] = 0;
                    }
                }
            }
        }
        return false;
    }
}
/*
1970. 你能穿过矩阵的最后一天
https://leetcode.cn/problems/last-day-where-you-can-still-cross/

第 254 场周赛 T4。

给你一个下标从 1 开始的二进制矩阵，其中 0 表示陆地，1 表示水域。同时给你 row 和 col 分别表示矩阵中行和列的数目。
一开始在第 0 天，整个 矩阵都是 陆地 。但每一天都会有一块新陆地被 水 淹没变成水域。给你一个下标从 1 开始的二维数组 cells ，
其中 cells[i] = [ri, ci] 表示在第 i 天，第 ri 行 ci 列（下标都是从 1 开始）的陆地会变成 水域 （也就是 0 变成 1 ）。
你想知道从矩阵最 上面 一行走到最 下面 一行，且只经过陆地格子的 最后一天 是哪一天。你可以从最上面一行的 任意 格子出发，到达最下面一行的 任意 格子。你只能沿着 四个 基本方向移动（也就是上下左右）。
请返回只经过陆地格子能从最 上面 一行走到最 下面 一行的 最后一天 。
提示：
2 <= row, col <= 2 * 10^4
4 <= row * col <= 2 * 10^4
cells.length == row * col
1 <= ri <= row
1 <= ci <= col
cells 中的所有格子坐标都是 唯一 的。

二分 + BFS
相似题目: 1631. 最小体力消耗路径
https://leetcode.cn/problems/path-with-minimum-effort/
 */
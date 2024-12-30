import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1926 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{entrance[0], entrance[1], 0});
        // entrance 格子 不算 出口。
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1], cstep = tuple[2];
                if ((cx == 0 || cx == m - 1 || cy == 0 || cy == n - 1) && maze[cx][cy] == '.') {
                    return cstep;
                }

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && maze[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cstep + 1});
                    }
                }
            }
        }
        return -1;
    }
}
/*
1926. 迷宫中离入口最近的出口
https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/

第 56 场双周赛 T2。

给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。
同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。
出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
提示：
maze.length == m
maze[i].length == n
1 <= m, n <= 100
maze[i][j] 要么是 '.' ，要么是 '+' 。
entrance.length == 2
0 <= entrancerow < m
0 <= entrancecol < n
entrance 一定是空格子。

BFS。
 */
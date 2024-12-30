import java.util.LinkedList;
import java.util.Queue;

public class SolutionP490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int M = maze.length;
        int N = maze[0].length;

        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == destination[0] && cur[1] == destination[1]) {
                    return true;
                }

                for (int[] dir : direction) {
                    int nextM = cur[0];
                    int nextN = cur[1];
                    // 在遇到墙壁前不会停止滚动。
                    while (nextM + dir[0] >= 0 && nextM + dir[0] < M && nextN + dir[1] >= 0 && nextN + dir[1] < N
                            && maze[nextM + dir[0]][nextN + dir[1]] == 0) {
                        nextM += dir[0];
                        nextN += dir[1];
                    }
                    if (!visited[nextM][nextN]) {
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
$490. 迷宫
https://leetcode.cn/problems/the-maze/

由空地（用 0 表示）和墙（用 1 表示）组成的迷宫 maze 中有一个球。球可以途经空地向 上、下、左、右 四个方向滚动，且在遇到墙壁前不会停止滚动。当球停下时，可以选择向下一个方向滚动。
给你一个大小为 m x n 的迷宫 maze ，以及球的初始位置 start 和目的地 destination ，
其中 start = [startrow, startcol] 且 destination = [destinationrow, destinationcol] 。请你判断球能否在目的地停下：如果可以，返回 true ；否则，返回 false 。
你可以 假定迷宫的边缘都是墙壁（参考示例）。
提示：
m == maze.length
n == maze[i].length
1 <= m, n <= 100
maze[i][j] is 0 or 1.
start.length == 2
destination.length == 2
0 <= startrow, destinationrow <= m
0 <= startcol, destinationcol <= n
球和目的地都在空地上，且初始时它们不在同一位置
迷宫 至少包括 2 块空地

跟普通 BFS 的区别是不是每次走一步，而是每次 “走到底”。
相似题目:
$505. 迷宫 II
https://leetcode.cn/problems/the-maze-ii/
$499. 迷宫 III
https://leetcode.cn/problems/the-maze-iii/
 */
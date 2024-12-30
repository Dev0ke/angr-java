import java.util.LinkedList;
import java.util.Queue;

public class Solution529 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private int M;
    private int N;

    public char[][] updateBoard(char[][] board, int[] click) {
        M = board.length;
        N = board[0].length;

        // 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        bfs(board, click[0], click[1]);
        return board;
    }

    private void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        boolean[][] visited = new boolean[M][N];
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int curM = cur[0];
            int curN = cur[1];

            int cnt = 0;
            for (int[] dir : DIRECTIONS8) {
                int nextM = curM + dir[0];
                int nextN = curN + dir[1];
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && board[nextM][nextN] == 'M') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                // 如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
                board[curM][curN] = (char) (cnt + '0');
            } else {
                // 如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
                board[curM][curN] = 'B';
                for (int[] dir : DIRECTIONS8) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N
                            && board[nextM][nextN] == 'E' && !visited[nextM][nextN]) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
    }
}
/*
529. 扫雷游戏
https://leetcode.cn/problems/minesweeper/

让我们一起来玩扫雷游戏！
给你一个大小为 m x n 二维字符矩阵 board ，表示扫雷游戏的盘面，其中：
- 'M' 代表一个 未挖出的 地雷，
- 'E' 代表一个 未挖出的 空方块，
- 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的 已挖出的 空白方块，
- 数字（'1' 到 '8'）表示有多少地雷与这块 已挖出的 方块相邻，
- 'X' 则表示一个 已挖出的 地雷。
给你一个整数数组 click ，其中 click = [clickr, clickc] 表示在所有 未挖出的 方块（'M' 或者 'E'）中的下一个点击位置（clickr 是行下标，clickc 是列下标）。
根据以下规则，返回相应位置被点击后对应的盘面：
1.如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
2.如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
3.如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
4.如果在此次点击中，若无更多方块可被揭露，则返回盘面。
提示：
m == board.length
n == board[i].length
1 <= m, n <= 50
board[i][j] 为 'M'、'E'、'B' 或数字 '1' 到 '8' 中的一个
click.length == 2
0 <= clickr < m
0 <= clickc < n
board[clickr][clickc] 为 'M' 或 'E'

BFS 模拟。
 */
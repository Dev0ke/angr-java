import java.util.LinkedList;
import java.util.Queue;

public class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                if (cur == n * n) {
                    return step;
                }

                for (int j = 1; j <= 6; j++) {
                    int next = cur + j;
                    if (next > n * n) {
                        break;
                    }
                    int[] rc = id2rc(next, n);
                    if (board[rc[0]][rc[1]] != -1) {
                        next = board[rc[0]][rc[1]];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int[] id2rc(int id, int n) {
        id--;
        int r = id / n;
        int c = id % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
/*
909. 蛇梯棋
https://leetcode.cn/problems/snakes-and-ladders/

给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。
玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
- 选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n2)] 。
  - 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
- 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
- 当玩家到达编号 n2 的方格时，游戏结束。
r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格上没有蛇或梯子。
注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
- 举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。
返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。
提示：
n == board.length == board[i].length
2 <= n <= 20
grid[i][j] 的值是 -1 或在范围 [1, n^2] 内
编号为 1 和 n2 的方格上没有蛇或梯子

BFS
 */
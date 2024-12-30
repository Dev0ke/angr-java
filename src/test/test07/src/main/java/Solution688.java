public class Solution688 {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] directions = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

        // dp[step][i][j] 表示骑士从棋盘上的点 (i,j) 出发，走了 step 步时仍然留在棋盘上的概率。
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1.0;
                    } else {
                        for (int[] dir : directions) {
                            int nextM = i + dir[0];
                            int nextN = j + dir[1];
                            if (nextM >= 0 && nextM < n && nextN >= 0 && nextN < n) {
                                dp[step][i][j] = dp[step][i][j] + dp[step - 1][nextM][nextN] / 8.0;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
/*
688. 骑士在棋盘上的概率
https://leetcode.cn/problems/knight-probability-in-chessboard/

在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
骑士继续移动，直到它走了 k 步或离开了棋盘。
返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
提示:
1 <= n <= 25
0 <= k <= 100
0 <= row, column <= n

动态规划。
时间复杂度 O(k*n^2)
空间复杂度 O(k*n^2)
相似题目: 576. 出界的路径数
https://leetcode.cn/problems/out-of-boundary-paths/
 */
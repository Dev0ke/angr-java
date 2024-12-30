public class SolutionP348 {
    static class TicTacToe {
        private final int n;
        private final int[][] rows;
        private final int[][] cols;
        private final int[][] diags;

        public TicTacToe(int n) {
            this.n = n;
            this.cols = new int[n][2];
            this.rows = new int[n][2];
            this.diags = new int[2][2];
        }

        public int move(int row, int col, int player) {
            if (++rows[row][player - 1] == n) {
                return player;
            }
            if (++cols[col][player - 1] == n) {
                return player;
            }
            if ((row == col) && (++diags[0][player - 1] == n)) {
                return player;
            }
            if ((row + col == n - 1) && (++diags[1][player - 1] == n)) {
                return player;
            }
            return 0;
        }
    }
}
/*
$348. 设计井字棋
https://leetcode.cn/problems/design-tic-tac-toe/

请在 n × n 的棋盘上，实现一个判定井字棋（Tic-Tac-Toe）胜负的神器，判断每一次玩家落子后，是否有胜出的玩家。
在这个井字棋游戏中，会有 2 名玩家，他们将轮流在棋盘上放置自己的棋子。
在实现这个判定器的过程中，你可以假设以下这些规则一定成立：
1. 每一步棋都是在棋盘内的，并且只能被放置在一个空的格子里；
2. 一旦游戏中有一名玩家胜出的话，游戏将不能再继续；
3. 一个玩家如果在同一行、同一列或者同一斜对角线上都放置了自己的棋子，那么他便获得胜利。
进阶:
您有没有可能将每一步的 move() 操作优化到比 O(n^2) 更快吗?

模拟。数组计数即可。
 */